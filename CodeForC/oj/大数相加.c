#include <stdio.h>
#include <string.h>
int main()
{
    char a[1000], b[1000];								
    int a1[1000]={0},b1[1000]={0},c[1001]={0};
    int n, j, k=0, i;
    scanf("%s%s",&a,&b);
    int lenga=strlen(a), lengb=strlen(b);
    for(i=0;i<lenga;i++)
        a1[i]=a[i]-'0';
    for(j=0;j<lengb;j++)
        b1[j]=b[j]-'0';
    while(i>=0&&j>=0)
    {
        c[k] = a1[i] + b1[j];
        i--;
        j--;
        k++;
    }
    if(i>0)
    {
		while(i--)
        {
            c[k] = a1[i];
            k++;
        }
    }
    else if(j>0)
    {
		while(j--)
        {
            c[k] = b1[j];
            k++;
        }
    }
    for(i=1;i<k;i++)
 		if(c[i]>=10)
	 	{
	 		c[i]%=10;c[i+1]++;
	 	}
    while(c[k]==0)
        k--;
    for (n = k; n > 0;n--)
        printf("%d", c[n]);
    return 0;
}
