#include <iostream>
using namespace std;
int max(int a,int b);
int min(int a,int b);
int main()
{
    int a[101], f[101], i, j, k, l, n;
    cin >> n;
    for (i = 1; i <= n;i++)
    {
        cin >> a[i];
        f[i] = 1;
    }
    for (i = 1; i <= n;i++)
    {
        for (j = 1; j <= i;j++)
        {
            if(a[j]<a[i])
            {
                f[i] = max(f[i], f[j] + 1);
            }
        }
        cout << f[i] << endl;
    }
    for (i = 1; i <= n;i++)
        k = max(k, f[i]);
    cout << k << endl;
    return 0;
}
int max(int a,int b)
{
    if(a>=b)
        return a;
    else
        return b;
}
int min(int a,int b)
{
    if(a<=b)
        return a;
    else
        return b;
}