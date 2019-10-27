#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
int main()
{
	int i,n,j,k;
	scanf("%d",&n);
	int *arry=(int *)malloc(sizeof(int)*(n+1));
	for(i=1;i<=n;i++) scanf("%d",arry[i]);
	i=1;j=n;
	while(i<j)
	{
		k=arry[i];
		arry[i]=arry[j];
		arry[j]=k;
	}
	for(i=1;i<=n;i++)
	{
		printf("%d",arry[i]);
		if(i!=n) printf(" ");
	}
	return 0;
}
