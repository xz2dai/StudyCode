#include<stdio.h>
#define N 10
void sort(int a[], int low, int high);
void swap(int a, int b)
{
    int cup;
    cup = a;
    a = b;
    b = cup;
}
int main(int argc,char *argv[])
{
    int k,a[N];
    printf("Please enter %d numbers", N);
    for (k = 0; k <= N - 1;k++)
    {
        scanf("%d", &a[k]);
    }
    sort(a, 0, N - 1);
    for (k = 0; k <= N - 1;k++)
    {
        printf("%d", a[k]);
    }
    system("pause");
    return 0;
}
void sort(int a[],int low,int high)
{
    int key,j,i;
    key = a[0];
    i = low;
    j = high;
    if(i>=j)
        return;
    while(i<j)
    {
        if(i!=j && a[j]>key)
            j--;
        if(i!=j && a[i]<key)
            i++;
        swap(a[i],a[j]);
    }
    swap(key, a[i]);
    sort(a, 0, i - 1);
    sort(a, i + 1, high);
    return;
}