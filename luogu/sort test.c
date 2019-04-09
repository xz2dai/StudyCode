#include<stdio.h>
int a[101];
int main(int argc,char* args[])
{
	int i, n;
	scanf("%d", &n);
	for (i = 1; i <= n;i++)
	{
		scanf("%d", &a[i]);
	}
	qsort(1, n);
	for (i = 1; i <= n;i++)
	{
		printf("%d", a[i]);
	}
	getchar();
	getchar();
	return 0;
}
int qsort(int low,int high)
{
	if(low>=high)
		return 0;
	int i=low+1, j=high, key=a[low];
	while(i<j && a[i]<key) 
		i++;
	while(i<j && a[j]>key)
		j++;
	swap()
}
int max(a,b)
{
	if(a>=b) return a;
	else
		return b;
}
int min(a,b)
{
	if(a<=b) return a;
	else
		return b;
}
int swap(int a,int b)