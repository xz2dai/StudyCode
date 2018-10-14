//首先我要写一个链表 然后想想怎么用链表实现
//链表遍历输出不需要考虑数的连续
#include<stdio.h>
#include<stdlib.h>
int again=0,k;

struct chan							//链表主体
{
	int number;
	struct chan *next;
}a[100001];

void sort(int low,int max)     //不清楚在加入结构后缀后sort部分有没有问题
{
	if(max<low) return; 
	int key,j,i,t;
	key=a[low].number;
	i=low;j=max;
	while(i!=j)
	{
		while(a[j].number>=key && i<j) j--;
		while(a[i].number<=key && i<j) i++;
		if(i<j)
		{
			t=a[i].number;
			a[i].number=a[j].number;
			a[j].number=t;
		}
	}
	a[low].number=a[i].number;
	a[i].number=key;
	sort(low,i-1);
	sort(i+1,max);
	return;
	
}
void Remove()                 //去除项，但是去除后怎么链接还要想想
{
	int jac;      //jac是随便写的，表示重复数量
	for (jac = 1; jac <= k;jac++)
	{
		if(a[jac].number==a[jac+1].number)
		{
			again++;        //在链表实现里好像不需要记录重复数
			a[jac].next=&a[jac+2].number;
		}
	}
}
void output(struct chan *node)
{
	
	node=&a[1];
	printf("%d",node->number);
	node=&node->next;
	while(node->next != NULL)
	{
		printf("%d",node->number);
		if(node->number == node->next.number)
		{
			node=&node->next.next;
			again+=1;
        }
	}
}
int main(int argc,char* argv[])
{
	int n;
	struct chan *p,*head;
	p=(struct chan *)malloc(sizeof(struct chan));
	scanf("%d",&k);
	for(n=1;n<=k;n++) 
		{
			scanf("%d",&a[n].number);
			a[n - 1].next = &a[n].number;
		}
	sort(1,k);
	return 0;
}