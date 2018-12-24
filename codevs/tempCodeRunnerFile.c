#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
    int front[101], n, i, k, j;
    scanf("%d", &n);
    for (i = 1; i <= n;i++)
    {
        scanf("%d", &front[i]);
    }
    printf("%dx^n",front[n]);
    for (i = n-1; i >= 1;i--)
    {
        if(front[i]=0)
            continue;
        if(front[i]>0)
            printf("+");
        printf("%dx^%d", front[i], i);
    }
    return 0;
}