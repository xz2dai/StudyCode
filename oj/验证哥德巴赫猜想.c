#include <stdio.h>
int book[5001]={0};
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
int test(int num)
{
    int q;
    for (q = 2; q <= num/2;q++)
    {
        if(book[q]==1)
        {
            if(book[num-q]==1 && q<=num-q)
                printf("%d=%d+%d\n", num, q, num - q);
            else
                continue;
        }
    }
    return 0;
}
int main(int argc, char const *argv[])
{
    int n, i;
    scanf("%d",&n);
    for (i = 2; i <= 5000;i++)
    {
        if(judge(i)==1)
            book[i] = 1;
    }
        for (i = 4; i <= n; i += 2)
        {
            test(i);
        }
    return 0;
}