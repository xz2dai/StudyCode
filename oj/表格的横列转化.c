#include<stdio.h>
#include<stdlib.h>
#include<math.h>
void rollback(int m,int n)
{
    int map1[m+1][n+1];
    int i, j, k;
    for (i = 1; i <= m;i++)
    {
        for (j = 1; j <= n;j++)
        {
            scanf("%d", &map1[i][j]);
        }
    }
    for (i = 1; i <= n;i++)
    {
        for (j = 1; j <= m;j++)
        {
            printf("%d",map1[j][i]);
            if(j!=m)
                printf(" ");
        }
            printf("\n");
    }

}
int main(int argc, char const *argv[])
{
    int n, i, a, b;
    scanf("%d", &n);
    for (i = 1; i <= n;i++)
    {
        scanf("%d%d", &a, &b);
        rollback(a, b);
        if(i!=n)
            printf("\n");
    }
        return 0;
}
