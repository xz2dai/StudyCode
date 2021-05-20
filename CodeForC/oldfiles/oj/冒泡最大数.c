#include<stdio.h>
#include<stdlib.h>
int a[1001];
int main()
{
    int i, j, k, n;
    int cup;
    scanf("%d", &n);
    for (i = 1; i <= n;i++)
        scanf("%d", &a[i]);
    for (i = 1; i <= n;i++)
    {
        for (j = 1; j <= n-i;j++)
        {
            if(a[j]>a[j+1])
            {
                cup = a[j];
                a[j] = a[j+1];
                a[j+1] = cup;
            }
        }
    }
    for (i = 1; i <= n;i++)
        system("pause");
    return 0;
}