#include<stdio.h>
int main()
{
    int i;
    char s[12];
    for (i = 1; i <= 12;i++)
    {
        scanf("%c", &s[i]);
        if(s[i]==" " || scanf("%c",&s[i])=='/r')
            break;
    }
    for (i = sizeof(s); i >= 0;i--)
        printf("%c", s[i + 1]);
        return 0;
}