#include<stdio.h>
int main()
{
    int a, b, n;
    scanf("%d%d",&a,&b);
    for (n = 0; n < b;n++) 
        {
            printf("%d ", a + n);
        }
        return 0;
}
