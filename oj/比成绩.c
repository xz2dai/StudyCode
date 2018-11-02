#include<stdio.h>
int main() {
	int n, i, max = -1, a, b;
	scanf("%d", &n);
	for (i = 1; i <= n;i++)
	{
		scanf("%d", &a);
		if(a>max)
			max = a;
	}
	printf("%d", max);
	return 0;
}
