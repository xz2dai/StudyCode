#include<stdio.h>
#include<stdlib.h>
double power(double x,int a)    //次方
{
	int n;
	double res=1.0;
	for(n=1;n<=a;n++) res*=x;
	return res;
}
int main()
{
	int n,i;
	scanf("%d%d",&n,&i);
	printf("%lf",power(n,i));
	return 0;
}
