#include<stdio.h>
int main()
{
    int n, i, k, j,cup,a[1001],book[1001]={0};
    scanf("%d", &n);
    for (i = 1; i <= n;i++)
    {
        int sum = 0;
        scanf("%d", &k);
        for (j = 1; j <= k;j++)
        {
            scanf("%d", &a[j]);
            if(a[j]<60)
                book[j] = 1;
        }
        for(j = 1; j <= k;j++)
        {
            if(book[j]==1)
            {
                printf("%d ",j);
                sum++;
            }
            if(sum==0)
                printf("all passed");
            printf("\n");
        }
    }
    return 0;
}
