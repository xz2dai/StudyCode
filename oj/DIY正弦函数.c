#include<stdio.h>
#include<stdlib.h>
int factorial(int a)			//阶乘
{
	int res=1;
	int i;
	for(i=a;i>=1;i--) res*=i;
	return res;
}
double power(double x,int a)    //次方
{
	int n;
	double res=1.0;
	for(n=1;n<=a;n++) res*=x;
	return res;
}
double mysin(double bow)
{
	double cup;
	if(bow==0) return 0;
	int n,i,k=1;
	double res=bow;
	for(i=3;i<=31;i+=2)
	{
		res+=power(-1,k)*(power(res,i)/factorial(i));
		k++;                                                                                                                                                                      
	}
	return res;
}
int main()
{
	int i,j,k,n;
	double bow;
	scanf("%d",&n);
	while(n--)
	{
		scanf("%lf",&bow);
		printf("%.9lf",mysin(bow));
		if(n!=1) printf("\n");
	}
	return 0;
}
