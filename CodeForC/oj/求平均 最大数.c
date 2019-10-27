#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    int a[3], b, c,ac=0,i,k,cup;
    double gg;
    scanf("%d%d%d", &a[1], &a[2], &a[3]);
    for (i = 1; i <= 3;i++)
    {
        if(a[i]>=60)
            ac++;
        b += a[i];
    }
    for (i = 1; i <= 3;i++)
    {
        for (k = 1; k <= 3;k++)
        {
            if(a[k]>a[k+1])          //交换
                 {
                     cup=a[k];
                     a[k]=a[k+1];
                     a[k+1]=cup;
                 }
        }
    }
    printf("%d %d %d %.1lf", ac, a[3], a[1], (double)b / 3);
    return 0;
}