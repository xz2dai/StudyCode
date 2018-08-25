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
    key=low;
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
	printf("Please input array size");
	scanf("%d",&n);
	printf("Please input array\n");
	for(u=1;u<=n+1;u++)  scanf("%d",&a[u]);
    printf("\n");
    sort(a[1],a[n+1]);
	for(u=1;u<=n+1;u++)  printf("%d",a[u]);
    system("pause");
    return 0;
}
