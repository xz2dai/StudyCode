#include<stdio.h>
#include<stdlib.h>
#define SIZE 100
typedef struct BiTNode
{
  char data;
  int flag;                          //标志变量          
  struct BiTNode *lchild, *rchild;   //左右孩子指针
}BiTNode,*BiTree;

BiTree CreatBTree(BiTree T){
    char a;
  //scanf("%c",&a);
  a=getchar();
  if(a=='0') T=NULL;
  else
  {
    T=(BiTree)malloc(sizeof(BiTNode));
	T->data=a;							     //生成跟结点
	T->lchild=CreateBiTree(T->lchild);  //构造左子树
	T->rchild=CreateBiTree(T->rchild);  //构造右子树
  }
  return T;     
}
void ShowBTree(){

}
void Preorder(){

}
void Inorder(){

}
void Levelorder(){

}
void LeafNum(){

}
void NodeCount(){

}
void TreeDepth(){

}
int main(int argc,char** args){

}