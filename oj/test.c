#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    int a;
    double b, c,r;
    scanf("%lf%lf%d", &b, &c, &a);
    r = (b * b) + (c * c) - (2 * b * c * cos(a));
    printf("%lf", r);
    return 0;
}