#include<stdio.h>
#include<stdlib.h>
int main()
{
	int stu[10001] = { 0 }, i, k, j, n;
	scanf("%d", &n);
	for (i = 1; i <= n; i++)
	{
		scanf("%d", &j);
		stu[j]++;
	}
	for (i = 1; i <= n; i++)
	{
		printf("%d score:%d", i, stu[i]);
		if (i != n) printf("\n");
	}
	return 0;
}
