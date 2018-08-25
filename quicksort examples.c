#include<stdio.h>
int a[101],n;
void quicksort(int left,int right)
{
    int i,j,t,temp;
    if (left>right) return;
    temp=a[left];  //temp存有基准数
    i=left;
    j=right;
    while(i!=j)
    {
        //先从右往左
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
int main()
{
    int i,j;
    scanf("%d ",&n);
    for(i=1;i<=n;i++)  printf("%d",a[i]);
    getchar();
    getchar();
    return 0;
}
