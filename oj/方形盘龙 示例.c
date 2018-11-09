#include<stdio.h>
int main() {
	int N, i, j, k, n, m, count = 1, t;
	scanf("%d", &t);
	for (m = 0; m < t; m++) {
		scanf("%d", &n);
		int a[n][n];
		if (n % 2 == 0) {
			N = n / 2;
		}
		else {
			N = n / 2 + 1;
		}
		for (i = 0; i < N; i++) {
			for (j = i; j < n - i; j++) {
				a[i][j] = count++;
			}
			k = n - i - 1;
			for (j = i + 1; j < n - i; j++) {
				a[j][k] = count++;
			}
			for (j = n - i - 2; j >= i; j--) {
				a[k][j] = count++;
			}
			for (j = n - i - 2; j >= i + 1; j--) {
				a[j][i] = count++;
			}
		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				printf("%4d", a[i][j]);
			}
			printf("\n");
		}
		printf("\n");
	}
	return 0;
}