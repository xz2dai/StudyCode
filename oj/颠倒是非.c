#include<stdio.h>
int main()
{
    int n, i, k,sum=0;
    scanf("%d%d", &n, &k);
    for (i = 1; i <= n;i++)
    {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        if(a!=b && c<=k)
            sum++;
    }
    printf("%d", sum);
}
