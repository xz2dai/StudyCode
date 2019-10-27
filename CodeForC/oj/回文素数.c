#include<stdio.h>
int judge(int num)
{
    int i, k = num;
    for(i=2;i<=k-1;i++)
	    if(k%i==0)
	        break;
	    if(i>k-1)
            return 1;
        else
            return 0;
}
int main(int argc, char const *argv[])
{
    int n, j, k, l;
    int a, b, c;
    scanf("%d",&n);
    while(n--)
    {
        scanf("%d", &j, &k);
        for (l = j; l <= k;l++)
        {
            if(judge(l)==1)
            {
                if(l<10)
                    printf("%d\n", l);
            }
        }
    }
    return 0;
}
