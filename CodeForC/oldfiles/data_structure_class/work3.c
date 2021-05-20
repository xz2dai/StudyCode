#include<stdio.h>

//结构定义
struct SeqStack
{
    char data[10];     //数据部分
    int top;            //栈顶位置
} DataStack;


//声明方法
void CreatStack(struct SeqStack *stack);
void InStack(struct SeqStack *stack,char *data);
void OutStackTop(struct SeqStack *stack);
int StackisFull(struct SeqStack *stack);
int StackisEmpty(struct SeqStack *stack);
int EqualStackTop(struct SeqStack *stack,char *x);
char getStackTop(struct SeqStack *stack);

int isQuit = 0;

int main(int args,char **argc){
    char buffer = ' ';        //缓冲输入变量
    char string[100];
    CreatStack(&DataStack);
    printf("请输入括号序列：");
    gets(string);
    /*
    scanf("%c",&buffer);
    while( (buffer == '(' || buffer == ')' || buffer == '[' 
        || buffer == ']' || buffer == '{' || buffer == '}') && isQuit == 0 ){
        EqualStackTop(&DataStack, &buffer);
        scanf("%c",&buffer);
    }
    */
    int i = 0;
    printf("开始配对\n");
    while(1){
        buffer = string[i];
        if(isQuit == 1){
            printf("此串括号匹配不合法!\n");
            break;
        }
        if(buffer == '\0' || buffer == ' ' || buffer == '\n'){
            if(DataStack.top != -1){
                printf("此串括号长度匹配不合法!");
                break;
            }else{
                printf("匹配\n");
                break;
            }
        }
        printf("开始匹配第%d个括号 ",i);
        EqualStackTop(&DataStack, &buffer);
        i++;
    }
    printf("程序结束");
}

//实现方法
void CreatStack(struct SeqStack *stack){            //初始化栈
    stack->top = -1;
}

void OutStackTop(struct SeqStack *stack){        //出栈首
    if(StackisEmpty(stack) == 0){
        printf("栈空！无法出栈");
    }else{
        stack->data[stack->top] = ' ';
        stack->top--;
        printf("栈顶出栈，当前栈顶位置为%d ", stack->top);
        if(stack->top == -1){
            printf("出栈后栈空 ");
        }else{
            printf("栈不为空，当前栈顶元素为%c  ", stack->data[stack->top]);
        }
    }
}

void InStack(struct SeqStack *stack,char *data){            //入栈
    if(StackisFull(stack) == 0){
        printf("栈满！无法入栈");
    }else{
        stack->top++;
        stack->data[stack->top] = *data;
        printf("入栈成功 ");
    }
}

int StackisFull(struct SeqStack *stack){                //判断栈满
    if(stack->top == 9){
        return 0;
    }else{
        return 1;
    }
}


int StackisEmpty(struct SeqStack *stack){               //判断栈空
    //当栈空时要么为程序开始，要么就是输入结束且语句符合需求
    if(stack->top == -1){
        return 0;
    }else{
        return 1;
    }
}

char getStackTop(struct SeqStack *stack){       //获取栈顶数据
    char *x = NULL;
    *x = stack->data[stack->top];
    return *x;
}

int EqualStackTop(struct SeqStack *stack,char *data){
    //将字符与栈顶对比,如果为左括号就直接压入栈，如果是右括号则与栈顶进行对比，与栈顶不同则失败，相同则将栈顶压出
    //这个函数是判断程序结束还是继续的关键
    if(*data == '(' || *data == '[' ||*data == '{'){
        printf("当前判断括号为左括号 ");
        if(StackisFull(stack) == 0){
            printf("栈满！程序停止\n");
            isQuit = 1;
            return 1;
        }else{
            InStack(stack, data);
            printf("左括号入栈成功!\n");
            return 0;
        }

    }else if(*data == ')' || *data == ']' || *data == '}'){
        printf("当前判断括号为右括号 ");
        if(StackisEmpty(stack) == 0){
            printf("此串括号匹配不合法,程序结束！\n");
            isQuit = 1;
            return 1;
        }else{
            printf("开始配对出栈流程 ");
            if(*data == ')'){
                if(stack->data[stack->top] == '('){
                        OutStackTop(stack);
                        printf("匹配成功，栈顶出栈\n");
                        return 0;
                    }else{
                        printf("配对失败，当前配对括号为%c,但当前栈顶为%c ", *data, stack->data[stack->top]);
                        printf("此串括号右括号匹配不合法,程序结束！\n");
                        isQuit = 1;
                        return 1;
                    }
            }else if(*data == ']'){
                if(stack->data[stack->top] == '['){
                        OutStackTop(stack);
                        printf("匹配成功，栈顶出栈\n");
                        return 0;
                    }else{
                        printf("配对失败，当前配对括号为%c,但当前栈顶为%c ", *data, stack->data[stack->top]);
                        printf("此串括号右括号匹配不合法,程序结束！\n");
                        isQuit = 1;
                        return 1;
                    }
            }else if(*data == '}'){
                if(stack->data[stack->top] == '{'){
                        OutStackTop(stack);
                        printf("匹配成功，栈顶出栈\n");
                        return 0;
                    }else{
                        printf("配对失败，当前配对括号为%c,但当前栈顶为%c ", *data, stack->data[stack->top]);
                        printf("此串括号右括号匹配不合法,程序结束！\n");
                        isQuit = 1;
                        return 1;
                    }
            }else{
                printf("无法判断右括号类型，程序结束!\n");
                    isQuit = 1;
                    return 1;
            }
        }

    }
    return 0;
}
