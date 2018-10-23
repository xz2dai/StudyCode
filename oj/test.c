#include<stdio.h>
#include<math.h>
#define PI 3.14159
int main()
{
<<<<<<< HEAD
    double a,b, c,r;
    scanf("%lf%lf%lf", &b, &c, &a);
    r = sqrt(b * b + c * c - 2 * b * c * cos((a/180)*PI));
    printf("%.2lf", r);
=======
    double a,b,s, c,r;
    scanf("%lf%lf%lf", &a,&b,&c);
    if(a+b<=c || a+c<=b ||b+c<=a) printf("-1");
    else 
	{
		s=(a+b+c)/2;
		r = sqrt(s*(s-a)*(s-b)*(s-c));
		printf("%lf",r);
	}
>>>>>>> 43f63a5ee7b466256c585f4d88348e0af6119961
    return 0;
}
