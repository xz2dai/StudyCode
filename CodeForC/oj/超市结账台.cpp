#include <stdio.h>
int main()
{
	int pn,amount,i,n,grade;
	double sum,price,fold;
	scanf("%d",&pn);
	while(pn--)
	{
		scanf("%d%d",&n,&grade);
		switch(grade)
		{
			case 0:
				fold=1.0;
				break;
			case 1:
				fold=0.98;
				break;
			case 2:
				fold=0.95;
				break;
			case 3:
				fold=0.93;
				break;
			default:
				fold=0.90;
				break; 
		}
		sum=0.0;
		for(i=0;i<n;i++)
		{
		scanf("%lf%d",&price,&amount);
		sum+=price*amount;
	}
	    printf("%.2lf\n",sum*fold);
	}
	    return 0;
    }   
