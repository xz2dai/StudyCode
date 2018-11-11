#include <stdio.h>
char a[2003][2003];//定义全局变量因为要最大也就2000 二维数组字符串
int main()
{
	int m,n,i;
	scanf("%d%d",&m,&n);
	for(i=0;i<m;i++)
		gets(a[i]);
	for(i=1;i<m;i=i+2)
		printf("%s\n",a[i]);
	for(i=0;i<m;i=i+2)
		printf("%s\n",a[i]);
	return 0;
}
