#include <stdio.h>
int main()
{
	int k,i;
	scanf("%d",&k);
	for(i=2;i<=k-1;i++)
	if(k%i==0)
	break;
	if(i>k-1)
	printf("yes");
	else
	printf("no"); 
	return 0;
}
