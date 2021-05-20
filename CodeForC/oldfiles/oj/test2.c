#include <stdio.h>
#include <stdlib.h>

int main()
{
	int i, j,cup,k;
	long long a[4];
	for (i = 1; i <= 3;i++)
		scanf("%lld", &a[i]);
		for (i = 1; i <= 3; i++)
		{
			for (k = 1; k <= 3; k++)
			{
				if (a[k] > a[k + 1])
				{
					cup = a[k];
					a[k] = a[k + 1];
					a[k + 1] = cup;
				}
			}
		}
		printf("%lld->%lld->%lld", a[1], a[2], a[3]);
		return 0;
}
