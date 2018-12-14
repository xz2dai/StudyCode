#include <stdio.h>
#include <string.h>
int main()
{
    char a[100000]={0}, b[100000]={0}, c[100000]={0};
    int n, j, k=1, i;
    scanf("%s%s",&a,&b);
    int lenga=strlen(a), lengb=strlen(b);
    for(i=0;i<lenga;i++)
        a[i]=a[i]-'0';
    for(j=0;j<lengb;j++)
        b[j]=b[j]-'0';
    while(i>=0&&j>=0)
    {
        c[k] = a[i] + b[j];
        if(c[k]>=10)
        {
            c[k] %= 10;
            c[k+1]+=1;
        }
        i--;
        j--;
        k++;
    }
    if(i>0)
    {
        k++; 
		while(i--)
        {
            c[k] = a[i];
            k++;
        }
    }
    else if(j>0)
    {
        k++;
		while(j--)
        {
            c[k] = b[j];
            k++;
        }
    }
    while(c[k]==0)
        k--;
    for (n = k; n > 1;n--)
        printf("%c", c[n] + '0');
    return 0;
}
