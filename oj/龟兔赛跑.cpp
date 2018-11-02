#include <stdio.h>
int main()
{
	int n,i,tor,rab;
	scanf("%d",&n);
	for(i=0;i<n;i++)
  {
	scanf("%d %d",&tor,&rab);
	    printf("time %d:",i+1);
	if(tor>rab)
	    printf("tortoise leading");
	else if(rab>tor)
	    printf("rabbit leading");
	else
	    printf("drawing");
	    printf("\n");
   }
    return 0;
}
