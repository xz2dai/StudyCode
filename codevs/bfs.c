#include<stdio.h>
int map[51][51]={0}, book[51][51]={0};
struct node
{
	int x;
	int y;
	int step;
};
struct move
{
	int x;
	int y;
};
int getsum(int x, int y)
{
	int sx, sy;
	int sum = 0;
	sy = y + 1;
	sx = x;
	while (map[sx][sy] != 1)		//���Ҳ���
	{
		if (map[sx][sy] == 2) sum++;
		sy++;
	}
	sy = y - 1;
	sx = x;
	while (map[sx][sy] != 1)		//�������
	{
		if (map[sx][sy] == 2) sum++;
		sy--;
	}
	sy = y;
	sx = x - 1;
	while (map[sx][sy] != 1)		//���ϲ���
	{
		if (map[sx][sy] == 2) sum++;
		sx--;
	}
	sy = y;
	sx = x + 1;
	while (map[sx][sy] != 1)		//���²���
	{
		if (map[sx][sy] == 2) sum++;
		sy++;
	}
	return sum;
}
int main()
{
	struct node nod[2502];
	int  i, n,j, k,high,wide,sx,sy,head,tail,p,q,tx,ty;
	struct move up = { -1,0 };
	struct move down = { 1,0 };
	struct move left = { 0,-1 };
	struct move right = { 0,1 };
	int next[4][2]={{0,1},{1,0},{0,-1},{-1,0}};
	scanf("%d%d",&high,&wide);
	for(i=1;i<=high;i++)
		for(j=1;j<=wide;j++)
			scanf("%d",&map[i][j]);
	scanf("%d%d%d%d",&sx,&sy,&p,&q);
	if (high > 50 || wide > 50) printf("Map too large");
	head=1;tail=1;
	nod[tail].x=sx;nod[tail].y=sy;nod[tail].step=0;
	tail++;
	book[sx][sy]=1;
	int flag=0;
	while(head<tail)
	{
		for(k=0;k<=3;k++)
		{
			tx=nod[head].x+next[k][0];
			ty=nod[head].y+next[k][1];
			if(tx<1 || tx>wide || ty<1 || ty>high) continue;
			if(map[tx][ty]==0 && book[tx][ty]==0)
			{
				book[tx][ty]==1;
				nod[tail].x=tx;
				nod[tail].y=ty;
				nod[tail].step+=1;
				tail++;
			}
			if(tx==p && ty==q)
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			break;
		}
		head++;
	}
	printf("%d",nod[tail-1].step);
	return 0;
}