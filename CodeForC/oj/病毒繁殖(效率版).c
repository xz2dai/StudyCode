#include <stdio.h>
int main()
{
	int k,i,n;
	long long unsigned f[93+1];
	scanf("%d",&k);
	while(k--)
	{
	    scanf("%d",&n);
		f[1]=f[2]=1;
		for(i=3;i<=n;i++)
		   f[i]=f[i-2]+f[i-1];
		printf("%llu\n",f[n]);
    }
    return 0;
 } 