#include<stdio.h>
int main()
{
	int n,i,max=-1,var;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		scanf("%d",&var);
		if(var>max) max=var;
	}
	printf("%d",max);
	return 0;
}
