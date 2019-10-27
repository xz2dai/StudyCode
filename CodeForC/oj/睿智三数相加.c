#include<stdio.h>
int main()
{
    int a,b,c,max=-1,i,n;
    for (i = 1; i <= 6;i++)
    {
        scanf("%d", &n);
        if(n>max)
            max = n;
    }
    printf("%d", max);
    return 0;
}
