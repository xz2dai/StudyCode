#include<stdio.h>
int main()
{
    int a, b, c, i;
    char n;
    scanf("%c", &n);
    for (c = 1; c <= 13;c+=2)
    {
        for (b = 1; b <= (13 - c)/2;b++)
            printf(" ");
        for (b = 1; b <= c; b++)
                printf("%c", n);
        if(c<13)
            printf("\n");
    }
    return 0;
}
