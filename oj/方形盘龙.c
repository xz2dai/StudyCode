#include<stdio.h>
#include<stdlib.h>
void draw(int side)
{
	int map[31][31] = { 0 };
	int i=1, j=1, key=1;
	while (key <= side * side)
	{
		if (j <= side && map[i][j] == 0)
		{
			map[i][j] = key;
			key++;
			if (j != side) j++;
		}
		if (i <= side && map[i][j] == 0)
		{
			map[i][j] = key;
			key++;
			if (j != side) i++;
		}
		if (j >=1 && map[i][j] == 0)
		{
			map[i][j] = key;
			key++;
			if (j != 1) j--;
		}
		if (i >=1 & map[i][j] == 0)
		{
			map[i][j] = key;
			key++;
			if (j != side) i--;
		}
	}
	for (i = 1; i <= side; i++)
	{
		for (j = 1; j <= side; j++) printf("%4d", map[i][j]);
		printf("\n");
	}
};
int main()
{
	int n,w, l,pan[1001];
	scanf("%d", &n);
	for (w = 1; w <= n; w++)
	{
		scanf("%d", &pan[w]);
	}
	for (l = 1; l <= n; l++)
	{
		draw(pan[l]);
	}
	system("pause");
	return 0;
}