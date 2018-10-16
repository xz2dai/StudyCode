#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    int a, b, i, k;
    scanf("%d%d", &a,&b);
    if((a+b)<0)
    {
        printf("%d", (a + b) + 7);
    }
    else
    {
        printf("%d", (a + b) % 7);
    }
    return 0;
}