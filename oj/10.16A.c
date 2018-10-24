#include<stdio.h>
#define PI 3.14159
int main()
{
    float r;
    scanf("%f", &r);
    printf("%f %f", PI * r * r, 2 * PI * r);
    return 0;
}