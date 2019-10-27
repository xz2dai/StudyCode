#include<stdio.h>
int a[101];
void swap(int *a, int *b);
void qsort(int low, int high);
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
void qsort(int low,int high)
{
	if(low>=high)
		return;
	int i=low+1, j=high, key=a[low];
	while(i<j && a[i]<key) 
		i++;
	while(i<j && a[j]>key)
		j++;
	swap(&key,&a[i]);

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
void swap(int *a,int *b)
{
    int t;
    t = *a;
    *a = *b;
    *b = t;
}