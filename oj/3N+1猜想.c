/*#include<stdio.h>
int main()
{
	int t=0,i,n;
	scanf("%d",&n);
	if(n%2==0)
	{
		while(n!=1)
		{
			n=n/2;
			t++;
		}
	}
	else if(n%2!=0)
	{
		while(n!=1)
		{
			n=((3*n)+1)/2;
			t++;
		}
	}
	printf("%d",t);
	return 0;
}*/
#include <stdio.h>

int main()
{
	int n, step=0;
	scanf("%d", &n);
	while(n != 1)
	{
		if(n % 2== 0) n=n/2;
		else n = (3*n +1)/2;
		step++;
	}
	printf("%d\n", step);
	return 0;
}