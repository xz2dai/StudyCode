#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    double a, b, c, s,t;
    scanf("%lf%lf%lf", &a, &b, &c);
    s = (a + b + c) / 2;
    t = sqrt(s * (s - a) * (s - b) * (s - c));
    printf("%lf", t);
    return 0;
}