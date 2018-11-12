#include<stdio.h>
int main()
{
	int k,j,l,m[101],n[101],s,s1,s2,i;
	scanf("%d",&k);
	for(i=1;i<=k;i++)
	{
		scanf("%d%d",&m[i],n[i]);
	}
	for(i=1;i<=k;i++)
	{
		s=n[i]-m[i];
		for(j=0;j<=s;j++)
		{
			for(s1=0;s1<j;s1++) printf("       ");
			for(s2=m[i]+j;s2<=n[i];s2++) printf("%d*%d=%-3d",m[i]+j,s2,s2*(m[i]+j));
			printf("\n");
			if(i!=k) printf("\n"); 
		}
	}
	return 0; 
}
