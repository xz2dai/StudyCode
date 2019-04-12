//先快排然后合并，每一次合并后都要更新序列，合并后的果堆不一定是最小果堆
#include<iostream>
#include<cstdlib>
using namespace std;
void qsort(int *arr,int low,int high)
{
	if(low>high) return;
	int i,j,key,t;
	i=low;
	key=arr[low];
	j=high;
	while(i!=j)
	{
		while(arr[j]>=key && i<j) j--;
		while(arr[i]<=key && i<j) i++;
		if(i<j)
		{
			t=arr[i];
			arr[i]=arr[j];
			arr[j]=t;
		}
	}
	arr[low] = arr[i];
	arr[i] = key;
	qsort(arr,low,i-1);
	qsort(arr,i+1,high);
	return;
}
int main(int argc, char const *argv[])
{
    int n, i, j, k;
	int cost = 0;
    int app[10001];
    cin >> n;
    for (i = 1; i <= n;i++)
        cin >> app[i];
    qsort(app,1,n);
	for (i=1;i<=n-1;i++)
	{
		cost+=app[i]+app[i+1];
		app[i+1]+=app[i];
		for(j=i+2;j<=n;j++)
		{
			if(app[i+1]>app[j])
			{
				int c = app[i+1];
				for(k=i+1;k<=j;k++)
				{
					app[k-1] = app[k];
				}
				app[j]=c;
			}
		}
	}
	cout<<cost;
        return 0;
}