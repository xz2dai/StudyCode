#include<stdio.h>
int main()
{
	int k,j,l,m,n,s,s1,s2,i;
	scanf("%d",&k);
	for(i=1;i<=k;i++)
	{
		scanf("%d%d",&m,&n);
		s=n-m;
		for(j=0;j<=s;j++)
		{
			for(s1=0;s1<j;s1++) printf("       ");
			for(s2=m+j;s2<=n;s2++) printf("%d*%d=%-3d",m+j,s2,s2*(m+j));
			if(i!=k) printf("\n");
		}
		return 0;
	}
}