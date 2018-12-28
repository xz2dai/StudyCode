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
    for (i = n; i >= 1;i--)
    {
        if(i==n)
        {
            if(front[i]==0)
                continue;
            else if(front[i]==1)
            {
                printf("x^%d", i);
                continue;
            }
            else if(front[i]==-1)
            {
                printf("-x^%d", i);
                continue;
            }
            else
            {
                    printf("%dx^%d", front[i], i);
                    continue;
            }
        }
        if(i==1)
        {
            switch(front[i])
            {
                case(0):
                    continue;
                case(1):
                    printf("+x");
                    break;
                case(-1):
                    printf("-x");
                    break;
                default:
                    if(front[i]>0)
                    {
                        printf("+%dx", front[i]);
                        break;
                    }
                    else
                    {
                        printf("%dx", front[i]);
                        break;
                    }
            }
            continue;
        }
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
    else if(front[0]<0) 
        printf("%d", front[0]);
    return 0;
}