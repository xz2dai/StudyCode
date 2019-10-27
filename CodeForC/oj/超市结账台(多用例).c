#include <stdio.h>

#include <stdlib.h>



int main()

{

    int pn,am,i,n,g;

    double sum,price;

    double f[5]={1,0.98,0.95,0.93,0.9};

    scanf("%d",&pn);

    while(pn--)

    {

        scanf("%d%d",&n,&g);

        sum=0.0;

        for(i=0;i<n;i++)

        {

            scanf("%lf%d",&price,&am);

            sum+=price*am;

        }

        printf("%.2lf\n",sum*f[g]);

    }



     return 0;

}
