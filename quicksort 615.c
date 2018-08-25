#include<stdio.h>
int a[101],n;
void swap(int a,int b)
{
    int mid;
	mid=a;
    a=b;
    b=mid;
}
void sort(int low,int high)
{
    int key,i,j;
    key=i;
    i=low-1;
    j=high;
    while(i>j) break;
    while(i<=j)
    {
        while(i<j && key<=a[j]) j--;
        while(i<j && key>=a[i]) i++;
        swap(a[i],a[j]);
    }
    while(i==j)
	{
		swap(key,a[i]);
	}
	sort(low,i-1);
	sort(i+1,high);
}
int main()
{
	int u;
	printf("请输入数列大小");
	scanf("%d",&n);
	printf("请输入数列 \n");
	for(u=1;u=n+1;u++)  scanf("%d",&a[u]);
	sort(a[1],a[n+1]);
	for(u=1;u=n+1;u++)  printf("%d",a[u]);
	getchar();getchar();
	return 0;
}
