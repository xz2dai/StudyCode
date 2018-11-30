#include<stdio.h>
int a[20];
void sort(int low,int max)
{
	if(max<low) return; 
	int key,j,i,t;
	key=a[low];
	i=low;j=max;
	while(i!=j)
	{
		while(a[j]>=key && i<j) j--;
		while(a[i]<=key && i<j) i++;
		if(i<j)
		{
			t=a[i];
			a[i]=a[j];
			a[j]=t;
		}
	}
	a[low]=a[i];
	a[i]=key;
	sort(low,i-1);
	sort(i+1,max);
	return;
}
int main(int argc,char* argv[])
{
	int n,k;
	scanf("%d",&k);
	for(n=1;n<=k;n++) scanf("%d",&a[n]);
	sort(1,k);
	printf("\n"); 
	for(n=1;n<=k;n++) printf("%d ",a[n]);
	return 0;
}
