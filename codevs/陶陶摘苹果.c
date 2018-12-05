#include<stdio.h>
#include<stdlib.h>
int main()
{
    int i,high[11], hand, sum=0;
    for (i = 1; i <= 10;i++)
    {
        scanf("%d", &high[i]);
    }
    scanf("%d", &hand);
    hand += 30;
    for (i = 1; i <= 10;i++)
    {
        if(hand>=high[i])
            sum++;
    }
    printf("%d", sum);
    system("pause");
    return 0;
}