#include<stdio.h>
int a[20];
void swap(int a,int b)
{
	int cup;
	cup=a;
	a=b;
	b=cup;
	return;
}
void sort(int max,int low)
{
	int key,j,i;
	key=a[low];
	i=low;j=max;
	while(i=!j)
	{
		while(a[j]>key) j--;
		while(a[i]<key) i++;
		swap(a[i],a[j]);
	}
	swap(key,a[i]);
	sort(low,i-1);
	sort(i+1,max);
	return;
}
int main(int argc,char* argv[])
{
	int n,m,k;
	printf("please enterput how many numbers you want to sort(less than 20)\n");
	scanf("%d",&k);
	printf("please enterput your numbers\n");
	for(n=1;n<=k;n++) scanf("%d",&a[n]);
	sort(1,k);
	for(n=1;n<=k;n++) printf("%d",a[n]);
	return 0;
}