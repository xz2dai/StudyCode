#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
    int front[101], n, i, k, j;
    scanf("%d", &n);
    for (i = n; i >= 0;i--)
    {
        scanf("%d", &front[i]);
    }
    printf("%dx^%d",front[n],n);
    for (i = n-1; i >= 2;i--)
    {
        switch(front[i])
        {
            case(0):
                continue;
            case(1):
                printf("+x^%d", i);
                break;
            case(-1):
                printf("-x^%d", i);
                break;
            default:
                if(front[i]>0)
                {
                    printf("+%dx^%d", front[i], i);
                    break;
                }
                else
                {
                    printf("%dx^%d", front[i], i);
                    break;
                }
        }
    }
    if(front[0]>0) printf("+%d", front[0]);
    else printf("%d", front[0]);
    return 0;
}