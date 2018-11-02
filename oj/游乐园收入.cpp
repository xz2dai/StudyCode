#include <stdio.h>
int main()
{
	int i,j,k,n,sum,t;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d",&k);
		sum=0;
		for(j=0;j<k;j++)
		{
			scanf("%d",&t);
			sum=sum+t;
		}
		printf("%d\n",sum);
	}
	return 0;
}
