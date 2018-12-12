#include<stdio.h>
#include<stdlib.h>
int main()
{
    int i, j, k, n;
    int cup;
    scanf("%d%d", &i, &j);
    if(i>j)
        printf("a>b");
    if(i<j)
        printf("a<b");
    if(i==j)
        printf("a==b");
    return 0;
}