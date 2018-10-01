#include<stdio.h>
int a[10001],again=0,k;
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
void check()
{
	int c,n;
	for(n=1;n<=k;n++)
	{
		if(a[n]==a[n+1])
		{
			again++;
			for(c=n;c<=k-again;c++)
			{
				a[c]=a[c+1];
			}
		}
	}
}
int main(int argc,char* argv[])
{
	int n;
	scanf("%d",&k);
	for(n=1;n<=k;n++) scanf("%d",&a[n]);
	sort(1,k);
	check();
	printf("%d",k-again);
	for(n=1;n<=k-again;n++) printf("%d ",a[n]);
	return 0;
}