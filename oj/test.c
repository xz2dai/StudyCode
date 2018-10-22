#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    double a,b, c,r;
    scanf("%lf%lf%lf", &b, &c, &a);
    r = sqrt(b * b + c * c - 2 * b * c * cos((a/180)*PI));
    printf("%.2lf", r);
    return 0;
}
