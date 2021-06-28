//¿ìËÙÅÅĞò
#include <stdio.h>
int a[8] = {3, 12, 6, 6, 4, 7, 10, 1};
void quicksort(int left, int right);
int main()
{
    quicksort(0, 8);
    for (int i = 0; i < 8; i++)
    {
        printf("%d ", a[i]);
    }
    return 0;
}
void quicksort(int left, int right)
{
    int i,j,t,temp;
    if (left>right) return;
    temp=a[left];  
    i=left;
    j=right;
    while(i!=j)
	{
        while(a[j]>=temp && i<j)  j--;
        while(a[i]<=temp && i<j)  i++;
        if(i<j)
        {
            t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
    }
    a[left]=a[i];
    a[i]=temp;
    quicksort(left,i-1);
    quicksort(i+1,right);
    return;
}