//先快排然后合并
#include<iostream>
#include<cstdlib>
using namespace std;
void qsort(int *arr,int low,int high)
{
	if(low>=high) return;
	int i,j,key,t;
	i=arr[low+1];
	key=arr[low];
	j=arr[high];
	while(i!=j)
	{
		while(arr[i]<=arr[key]&&i<j) i++;
		while(arr[j]>=arr[key]&&i<j) j--;
		if(i<j)
		{
			t=arr[i];
			arr[i]=arr[j];
			arr[j]=t;
		}
		arr[low]=arr[i];
		arr[i]=key;
		qsort(arr,low,i-1);
		qsort(arr,i+1,high);
		return;
	}
}
int main(int argc, char const *argv[])
{
    int n, i, j, k;
	int cost;
    int app[10001];
    cin >> n;
    for (i = 1; i <= n;i++)
        cin >> app[i];
    qsort(app,1,n);
	for(i=1;i<=n-1;i++)
	{
		cost+=app[i]+app[i+1];
		app[i+1]+=app[i];
	}
	cout<<cost;
        return 0;
}