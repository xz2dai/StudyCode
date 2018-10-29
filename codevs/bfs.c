#include<stdio.h>
int map[51][51], book[51][51];
struct node
{
	int x,y,total;
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
	struct node nod[2500];
	int  i, n, k,high,wide,sx,sy;
	struct move up = { -1,0 };
	struct move down = { 1,0 };
	struct move left = { 0,-1 };
	struct move right = { 0,1 };
	scanf("%d%d%d%d", &high, &wide,&sx,&sy);
	if (high > 50 || wide > 50) printf("Map too large");
	for (i = 1; i <= high; i++)
	{
		for (n = i; n <= wide; n++) scanf("%d", &map[high][wide]);
	}
	book[sx][sy] = 1;		//��ʱ������,��-��-��-��

	return 0;
}