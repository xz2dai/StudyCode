#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
    double a,b,s, c,r;
    scanf("%lf%lf%lf", &a,&b,&c);
    if(a+b<=c || a+c<=b ||b+c<=a) printf("-1");
    else 
	{
		s=(a+b+c)/2;
		r = sqrt(s*(s-a)*(s-b)*(s-c));
		printf("%lf",r);
	}
    return 0;
}
