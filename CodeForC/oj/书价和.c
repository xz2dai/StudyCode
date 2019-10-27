#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    int a[11], i;
    double totol;
    for (i = 1; i <= 10;i++)
    {
        scanf("%d", &a[i]);
    }
    totol = (a[1] * 28.9) + (a[2] *32.7)+(a[3] *45.6)+(a[4] * 78)+(a[5] *35)+(a[6] *86.2)+(a[7] *27.8)+(a[8] *43)+(a[9] *56)+(a[10] *65);
    printf("%.2lf", totol);
    return 0;
}