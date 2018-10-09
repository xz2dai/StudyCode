#include<stdio.h>
#include<math.h>
int main()
{
    double a,b,c,s,S;
    scanf("%lf%lf%lf",&a,&b,&c);
    s=(a+b+c)/2;
    S=sqrt(s*(s-a)*(s-b)*(s-c));
    printf("%lf",S);
    getchar();
    getchar();
    return 0;
}