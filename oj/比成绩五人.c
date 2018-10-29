#include<stdio.h>
int main() {
  int n,i,max1,max2,max3,a,b;
  for(i=1;i<=3;i++)
  {
  	a=-1;
  	for(n=1;n<=5;n++)
  	{
  	        scanf("%d",&b);
  	        if(b>a) a=b;
  	}
  	if(i==1) max1=a;
  	if(i==2) max2=a;
  	if(i==3) max3=a;
  }
  printf("%d\n%d\n%d",max1,max2,max3);
  return 0;
}
