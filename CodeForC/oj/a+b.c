#include<stdio.h>
int add(int a,int b)
{
    return a + b;
}
int main()
{
    int i, j, k, n,a,b;
    while(1)
    {
        if(scanf("%d%d", &a, &b)==EOF)
            break;
        printf("%d", add(a, b));
        if(i!=n)
            printf("/n");
    }
        return 0;
}