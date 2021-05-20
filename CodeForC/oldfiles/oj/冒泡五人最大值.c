#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    int a[5],i,k,cup;
    scanf("%d%d%d%d%d", &a[1], &a[2],&a[3],&a[4],&a[5]);
    for (i = 1; i <= 5;i++)
    {
        for (k = 1; k <= 4;k++)
        {
            if(a[k]>a[k+1])          //交换
                 {
                     cup=a[k];
                     a[k]=a[k+1];
                     a[k+1]=cup;
                 }
        }
    }
    printf("%d",a[5]);
    return 0;
}