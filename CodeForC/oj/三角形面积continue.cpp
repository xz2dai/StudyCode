#include <stdio.h>
#include <math.h>
int main()
{
	int a,b,c,n,i;
	double s,S;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d%d%d",&a,&b,&c);
		if(a+b<=c||a+c<=b||b+c<=a)
		{
			printf("-1\n");
			continue;
		}
		s=(a+b+c)/2.0;
		S=sqrt(s*(s-a)*(s-b)*(s-c));
		printf("%.4lf\n",S);
	}
	return 0;
}
