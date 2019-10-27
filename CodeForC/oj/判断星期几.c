#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    int a, b, i, k,j,l;
    scanf("%d", &j);
    for ( l= 1; l <= j;l++)
    {
        scanf("%d%d", &a,&b);
        if((a+b)<0)
        {
            printf("%d", (a + b) + 7);
            if(l!=j)
                printf("\n");
        }
        else
        {
            printf("%d", (a + b) % 7);
            if(l!=j)
                printf("\n");
        }
    }
    return 0;
}