#include <stdio.h>

int main()
{
	int n,i,k,sum=0,sumbook,a[1001];
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		scanf("%d",&a[i]);
		if(a[i]<60) sum++;
	}
	if(sum==0)
	{
		printf("0\n");
		printf("no fail");
	}
	else 
	{
		sumbook=sum;
		printf("%d\n",sum);
		for(i=1;i<=n;i++)
		{
			if(a[i]<60&&sumbook==1) printf("%d",i);
			else if(a[i]<60&&sum!=0)
			{
				printf("%d ",i);
				sumbook--;
			}
		}
	} 
	return 0;
}
