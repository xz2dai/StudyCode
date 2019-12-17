#include<stdio.h>

//结构定义
struct SeqStack
{
    char data[100];
    int top;
    int length;
} DataStack;


//声明方法
void CreatStack();
void InStack();
void OutStack();
int StackisFull();
int StackisEmpty();
int EqualStackTop();
void getStackTop();

int main(int args,char **argc){
    char buffer;
    int i, j, k;
    CreatStack();
    printf("请输入括号序列(输入任意英文字符停止输入)：");
    while(scanf("%c",&DataStack.data[DataStack.top]),       //不写入栈方法是因为这里已经实现了
        DataStack.data[DataStack.top] == '(' ||
        DataStack.data[DataStack.top] == ')' ||
        DataStack.data[DataStack.top] == '[' ||
        DataStack.data[DataStack.top] == ']' ||
        DataStack.data[DataStack.top] == '{' ||
        DataStack.data[DataStack.top] == '}')
    {
        DataStack.top++;
        DataStack.length++;
        if(EqualStackTop() == 1){                   //判断输入元素性质
            break;
        }else{
            OutStack();
        }
    }
}

//实现方法
void CreatStack(struct SeqStack *stack){            //初始化栈

}

void OutStack(struct SeqStack *stack,int position){        //出栈

}


int StackisFull(struct SeqStack *stack){                //判断栈空
    if(stack->length == 100){
        return 1;
    }else{
        return 0;
    }
}


int StackisEmpty(struct SeqStack *stack){               //判断栈空
    if(stack->length == 0){
        return 1;
    }else{
        return 0;
    }
}


int EqualStackTop(struct SeqStack *stack,char *x){      //将字符与栈顶对比
    return 0;
}


void getStackTop(struct SeqStack *stack,char *x){       //获取栈顶数据
    *x = stack->data[stack->top];
    return;
}
