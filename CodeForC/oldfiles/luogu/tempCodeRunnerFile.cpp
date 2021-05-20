#include<bits/stdc++.h>
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
    int app[10002];
    cin >> n;
    for (i = 1; i <= n;i++)
        cin >> app[i];
    qsort(app,1,n);								//排序果堆,找出最小的两个堆
	for (i=1;i<=n-1;i++)
	{
		app[i+1]+=app[i];		//合并果堆
		cost += app[i + 1];	
		app[i] = 0;
		qsort(app, i + 1, n);
		for (k = i + 1; k <= n; k++)
			cout << app[k] << " ";
		cout << endl;
	}
	cout<<cost;
    return 0;
}