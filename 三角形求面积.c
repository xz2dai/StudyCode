#include<stdio.h>
#include<math.h>
int main()
{
    double a,c,b,S,s;
    scanf("%lf%lf%lf", &a, &b, &b);
    s = (a + b + c) / 2;
    S=sqrt(s * (s - a) * (s - b) * (s - c));
    printf("%lf", S);
    return 0;
}
