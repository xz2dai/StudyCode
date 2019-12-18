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
void getStackTop(struct SeqStack *stack,char *x);

int isQuit = 0;

int main(int args,char **argc){
    char buffer;        //缓冲输入变量
    CreatStack(&DataStack);
    printf("请输入括号序列(输入任意英文字符或不匹配括号停止输入)：");
    /*
    **实现方法过于复杂被放弃
    while(scanf("%c",&DataStack.data[DataStack.top]),       //不写入栈方法是因为这里已经实现了
        DataStack.data[DataStack.top] == '(' ||
        DataStack.data[DataStack.top] == ')' ||
        DataStack.data[DataStack.top] == '[' ||
        DataStack.data[DataStack.top] == ']' ||
        DataStack.data[DataStack.top] == '{' ||
        DataStack.data[DataStack.top] == '}')
    {
        DataStack.top++;
        if(EqualStackTop() == 1){                   //判断输入元素性质
            break;
        }else{
            OutStack();
        }
    }
    */

    scanf("%c",&buffer);
    while( (buffer == '(' || buffer == ')' || buffer == '[' 
        || buffer == ']' || buffer == '{' || buffer == '}') && isQuit == 0 ){
        EqualStackTop(&DataStack, &buffer);
        scanf("%c",&buffer);
    }
}

//实现方法
void CreatStack(struct SeqStack *stack){            //初始化栈
    stack->top = -1;
}

void OutStackTop(struct SeqStack *stack){        //出栈首
    if(StackisEmpty(stack) == 0){
        printf("栈空！");
    }else{
        stack->top--;
    }
}

void InStack(struct SeqStack *stack,char *data){            //入栈
    if(StackisFull(stack) == 0){
        printf("栈满！无法入栈");
    }else{
        stack->data[stack->top] = *data;
        stack->top++;
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

void getStackTop(struct SeqStack *stack,char *x){       //获取栈顶数据
    *x = stack->data[stack->top];
    return;
}

int EqualStackTop(struct SeqStack *stack,char *data){
    //将字符与栈顶对比,如果为左括号就直接压入栈，如果是右括号则与栈顶进行对比，与栈顶不同则失败，相同则将栈顶压出
    //这个函数是判断程序结束还是继续的关键
    if(*data == '(' || *data == '[' ||*data == '{'){
        if(StackisEmpty(stack) == 0){
            InStack(stack, data);
        }else if(StackisFull(stack) == 0){
            printf("栈满！程序停止");
            isQuit = 1;
        }else{
            InStack(stack, data);
        }

    }else if(*data == ')' || *data == ']' || *data == '}'){
        if(StackisEmpty(stack) == 0){
            printf("语句不合法,程序结束！");
            isQuit = 1;
        }else{
            if(stack->data[stack->top] == *data){
                OutStackTop(stack);
            }else{
                printf("语句不合法,程序结束！");
                isQuit = 1;
            }
        }

    }
    return 0;
}
