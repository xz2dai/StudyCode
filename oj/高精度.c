#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
	char a[20],b[20],c[21],s;
	int i,j,k,n;
	while(1)
	{
		i=21;
		getch(s);
		if(s!='\r') a[i]=s;
		else continue;
	}
	while(1)
	{
		i=21;
		getch(s);
		if(s!='\r') b[i]=s;
		else continue;
	}
	for(i=21;i>=0;i--)
	{
		c[i]=a[i]+b[i]-'0';
	}
	for(i=21;i>=0;i--)
	 printf("%c",c[i]);
	return 0;
}
