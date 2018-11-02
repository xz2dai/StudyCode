#include<stdio.h>
int main()
{
    int n, i, k, j;
    scanf("%d%d", &n,&k);
    for (i = 1; i <= n;i++)
    {
        if(i==1 || i==n)
		{
            for (j = 1; j <= k;j++)
                printf("#");
            printf("\n");
		}
        else
        {
            printf("#");
            for (j = 1; j <= k - 2;j++)
                printf(" ");
            printf("#\n");
        }
        
    }
    return 0;
}
