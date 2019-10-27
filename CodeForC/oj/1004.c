#include<stdio.h>
int main()
{
    int n, k[101],i,s,j,cp;
    float a[101][101],cup,totol,p[101];
    scanf("%d", &n);
    for (i = 1; i <= n;i++)
    {
        scanf("%d", &k[i]);
        for (s = 1; s <= k[i];s++)
        {
            scanf("%f", &a[i][s]);
        }
        for (s = 1; s <= k[i];s++)
        {
            for (j = 1; j <= k[i] - 1;j++)
            {
                if(a[i][j]>a[i][j+1])          //交换
                 {
                     cup=a[i][j];
                     a[i][j]=a[i][j + 1];
                     a[i][j + 1]=cup;
                 }
            }
        }
    }
    for(i=1;i<=n;i++)
    {
        for (s = 1; s <= k[i];s++)
        {
            totol += a[i][s];
            p[i] = totol / k[i];
        }
        cp = k[i];
        printf("%.2f %.2f %.2f",a[i][cp],a[i][1],p[i]);
        printf("\n");
	}
	return 0;
}
