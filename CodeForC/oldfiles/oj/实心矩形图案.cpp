#include <stdio.h>
int main()
{
	int i,j,m,n;
	char ch;
	scanf("%d %d %c",&m,&n,&ch);
	for(i=1;i<=m;i++)
	{
	for(j=1;j<=n;j++)
	printf("%c",ch);
	printf("\n");
   }
	return 0;
}
