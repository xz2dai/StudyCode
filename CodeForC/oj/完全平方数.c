#include<stdio.h>
#include<math.h>
int right(int num)
{
	if(sqrt(num)==(int)sqrt(num)) return 1;
	else return 0;
}
int main()
{
	int n,i,k;
	while(1)
	{
		scanf("%d",&n);
		if(n==-1) break;
		if(right(n)==1) printf("Yes");
		else printf("No");
		printf("\n");
	}
	return 0;
}