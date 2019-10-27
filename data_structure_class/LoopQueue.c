#include<stdio.h>
/*
    Author:袁铨
    Topic:循环队列
    DATA:2019-10-13
*/
const int MAX = 10;
struct LoopQueue{
        int Data[MAX];
        int front;
        int rear;
    };
void InitQueue(struct LoopQueue *Q){
    //初始化
    Q->front = Q->rear = 0;
}
int EmptyQueue(struct LoopQueue *Q){
    //判断队是否为空
    if(Q->front==Q->rear){
        return 1;
    } else {
        return 0;
    }
}

int InQueue(struct LoopQueue *Q,int data){
    //入队函数
    if((Q->rear+1)%MAX == Q->front){
        printf("队满，无法入队");
        return 0;
    }else{
        Q->rear = (Q->rear + 1) % MAX;
        Q->Data[Q->rear] = data;
        return 1;
    }
    
}

int DeQueun(struct LoopQueue *Q,int *x){
    //出队函数
    if(Q->rear == Q->front){
        printf("队空！无法出队");
        return 0;
    }else{
        Q->front = (Q->front + 1) % MAX;
        *x = Q->Data[Q->front];
        return 1;
    }
    return 0;
}

int GetFront(struct LoopQueue *Q,int *x){
    //获取队头
    if(Q->rear == Q->front){
        printf("队空！无对头元素");
        return 0;
    }else{
        *x = Q->Data[Q->front];
        return 1;
    }
}

int ShowQueue(struct LoopQueue *Q){
    //显示队列中元素
    int key = Q->front;
    if(key == Q->rear){
        printf("队空！无元素");
        return 0;
    }else{
        printf("从队头开始元素为：");
        while(key!=Q->rear){
            printf("%5d", Q->Data[key + 1]);
            key++;
        }
    }

}

void showMenu(){
    //菜单函数
    printf("请输入数字以进行相关操作！(队列已经自动创建)\n");
    printf("1-入队操作\n");
    printf("2-出队操作\n");
    printf("3-获取队头元素\n");
    printf("4-输出队列中所有元素\n");
    printf("0-结束程序\n");
}




int main(int argc, char *args[])
{
    int isQuit = 0,n,k;
    struct LoopQueue Q;
    InitQueue(&Q);
    while(isQuit != 1){
        showMenu();
        scanf("%d", &n);
    switch(n){
        case 1:{
            printf("请输入想要入队的数字:");
            scanf("%d", &k);
            InQueue(&Q, k);
            printf("\n");
            break;
        }
        case 2:{
            printf("出队数字为：");
            DeQueun(&Q, &k);
            printf("%d\n", k);
            break;
        }
        case 3:{
            printf("队头元素为：");
            GetFront(&Q, &k);
            printf("%d\n", k);
            break;
        }
        case 4:{
            ShowQueue(&Q);
            break;
        }
        case 0:{
            isQuit = 1;
            break;
        }
        default:
            printf("请输入正确的指令！\n");
            break;
    }
    }
    return 0;
}