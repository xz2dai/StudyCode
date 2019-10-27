#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int result(int a,int b)
{
	int other;
	other=a/b;
	if(other>0) 
	{
		if(a%b==0)
			printf("%d",other);
		else
		{
			a-=b*other;
			printf("%d(%d/%d)",other,a,b);
		}
	}
	else
		printf("%d/%d",a,b);
	return 0;
}
int main()
{
	int a,b,n,i,k,j;
	scanf("%d/%d",&a,&b);
	result(a,b);
	return 0;
}
