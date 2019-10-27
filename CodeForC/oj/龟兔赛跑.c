#include<stdio.h>
#include<string.h>
char tw[] = "tortoise leading", dr[] = "drawing", rw[] = "rabbit leading";
char judge(int a,int b)
{
	if (a > b) return rw;
	if (a = b)	return dr;
	if (a < b) return tw;
};
int main()
{
	int i, k, n,r,t;
	scanf("%d%d", &t, &r);
	printf("%s", judge(r, t));
	return 0;
}