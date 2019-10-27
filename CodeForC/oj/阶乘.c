#include<stdio.h>
#include<stdlib.h>
int factorial(int a)			//阶乘
{
	int res=1;
	int i;
	for(i=a;i>=1;i--) res*=i;
	return res;
}
int main()
{
	int n;
	scanf("%d",&n);
	printf("%d",factorial(n));
	return 0;
} 
