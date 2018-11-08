#include<stdio.h>
int main() {
	int n, i, max = -99999, a, b;
	for (i = 1; i <= 10;i++)
	{
		scanf("%d", &a);
		if(a>max)
			max = a;
	}
	printf("%d", max);
	return 0;
}
