#include<stdio.h>
#include<stdlib.h>
int main()
{
    int i, n,num[11],max=-1,maxp=0;
    scanf("%d", &n);
    for (i = 0; i < n;i++)
    {
        scanf("%d", &num[i]);
        if(num[i]>max)
        {
            max = num[i];
            maxp = i;
        }
    }
    printf("%d %d", max, maxp);
    system("pause");
    return 0;
}