#include <stdio.h>
int main()
{
	int n,a,b,r;
	char ch;
	scanf("%d",&n);
	while(n--)
	{
		scanf("%d%c%d",&a,&ch,&b);
		switch(ch)
		{
			case'+':
			  r=a+b;
			  break;
			case'-':
			  r=a-b;
			  break;
			case'*':
			  r=a*b;
			  break;
			case'/':
			  r=a/b;
			  break;
			case'%':
			  r=a%b;
			  break;
		}
		printf("%d\n",r);
	}
	return 0;
}
