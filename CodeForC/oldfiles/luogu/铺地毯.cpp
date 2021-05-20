#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
int main()
{
	int i,j,k,n;
	int x,y;
	int carpet[10001][5];
	cin>>n;
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=4;j++)
			cin>>carpet[i][j];
	}
	cin>>x;
	cin>>y;
	for(i=n;i>=1;i--)
	{
		if((x<=carpet[i][1]+carpet[i][3] && x>=carpet[i][1]) && (y<=carpet[i][2]+carpet[i][4] && y>=carpet[i][2]))
		{
			k=i;
			break;
		}
	}
	cout<<k;
	return 0;
}