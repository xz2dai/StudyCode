#include <stdio.h>
int main()
{
	int i,j,n;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		for(j=1;j<i;j++)
		printf("       ");
		for(j=i;j<=n;j++)
		printf("%d*%d=%-3d",i,j,i*j);
		printf("\n");
	}
	return 0;
}
