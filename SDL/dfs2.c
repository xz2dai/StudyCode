#include<stdio.h>
int a[10],book[10],totol;
void dfs(int step);
int main()
{
	dfs(1);
	printf("Totol is %d",totol/2);
	return 0;
}
void dfs(int step)
{
	int i;
	if(((a[1]*100+a[2]*10+a[3])+(a[4]*100+a[5]*10+a[6]))==(a[7]*100+a[8]*10
}