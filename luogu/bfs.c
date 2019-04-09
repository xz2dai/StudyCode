#include<stdio.h>
#include<stdlib.h>
struct note
{
	int x;
	int y;
	int s;
};
int main()
{
	struct note que[2051];
	int a[50][50]={0},book[50][50]={0};
	int next[4][2]={{0,1},{1,0},{0,-1},{-1,0}};
	int head,tail;
	int i,j,k,n,m,startx,starty,p,q,tx,ty,flag;
	scanf("%d%d",&n,&m);
	for(i=1;i<=n;i++)
		for(j=1;j<=m;j++)
			scanf("%d",&a[i][j]);
	scanf("%d%d%d%d",&startx,&starty,&p,&q);
	head=1;
	tail=1;
	que[tail].x=startx;
	que[tail].y=starty;
	que[tail].s=0;
	tail++;
	book[startx][starty]=1;
	while(head<tail)
	{
		for(k=0;k<=3;k++)
		{
			tx=que[head].x+next[k][0];
			ty=que[head].x+next[k][1];
			if(tx<1||ty<1||tx>n||ty>m) continue;
			if(a[tx][ty]==0&&book[tx][ty]==0)
			{
				book[tx][ty]=1;
				que[tail].x=tx;
				que[tail].y=ty;
				que[tail].s=que[head].x+1;
				tail++;
			}
			if(tx==p&&ty==q)
			{
				flag=1;
				break;
			}
		}		
		if(flag==1)  break;
		head++;
	}
	printf("%d",que[tail-1].s);
	return 0;
}