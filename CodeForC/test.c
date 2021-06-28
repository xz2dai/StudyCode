#include <stdio.h>
int a[8] = {3, 12, 6, 6, 4, 7, 10, 1};
int main()
{
    // for (int i = 0; i < 8; i++)
    // {
    //     printf("%d ", a[i]);
    // }
    printf("%d", (int)(sizeof(a)/sizeof(int)));
    return 0;
}