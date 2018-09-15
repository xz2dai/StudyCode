#include<stdio.h>
int a[20];
void sort(int max,int low)
{
	int key,n,m,j,i;
	key=(max+low)/2;
	j=low;i=max;
	while(j<i && j<key && i>key)
	{
		j++;
		if(a[j]>a[key]) i--;
		if(a[i]<a[key]) swap(a[j],a[i]);
	}
	if(j=key) swap(a[i],a[key]);
	if(i=key) swap(a[j],a[key]);
	
	
}