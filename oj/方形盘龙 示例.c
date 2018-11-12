#include<stdio.h>
#include<math.h>
int main()
{
   int n,i,j,k,cases,a[30][30];
   scanf("%d",&cases);
   while(cases--)
   {
       scanf("%d",&n);
       for(i=0; i<n; i++)
           for(j=0; j<n; j++)
            a[i][j]=0;
       i=j=-1;
       k=1;
       while(k<=n*n)
       {
           for(i++,j++; j<n&&a[i][j]==0; j++)a[i][j]=k++;
           for(i++,j--; i<n&&a[i][j]==0; i++)a[i][j]=k++;
           for(i--,j--; j>=0&&a[i][j]==0; j--)a[i][j]=k++;
           for(i--,j++; i>=0&&a[i][j]==0; i--)a[i][j]=k++;
       }
       for(i=0; i<n; i++)
       {
           for(j=0; j<n; j++)printf("%4d",a[i][j]);
           printf("\n");
       }
       printf("\n");
   }
   return 0;
}
