#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
	int i,j,k,cup;
	char a[1002],b[1002],re[1003];
	gets(a);
	gets(b);
	int lena,lenb;
	if(strlen(a)>strlen(b)) lena=strlen(a);
	else lena=strlen(b);
	for(i=2;i<=lena;i++)
	{
		re[i]=(a[i]+b[i])-48;
		if(re[i]>=58)
		{
			re[i]-=58;
			re[i-1]+=1;
		}
	}
	for(i=0;i<=1003;i++)
	{
		if(re[i]>=48&&re[i]<=57) 	 printf("%c",re[i]);
	}
	return 0;
}

