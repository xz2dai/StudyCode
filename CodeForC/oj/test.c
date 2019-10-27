#include <stdio.h>
#include <stdlib.h>
#include<math.h>
int main()
{
    int n,i,f=0;
    scanf("%d",&n);
    for(i=1;i<=n;i++){
     int cj;
     scanf("%d",&cj);
     if(cj<60)
            printf("%d ",i);
            f=f+1;
    }
    if(f==0)
        printf("no fail");
    else
        printf("\n");
        printf("%d",f);
    return 0;
}


