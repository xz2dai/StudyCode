

#include <stdlib.h>

#include <stdio.h>

int main() {

  int i, j, n, t, k, sum, a[100][100] = { };

  while (1) {

    scanf("%d", &n);

    if (n % 2 == 1)
      break;

  }

  k = (n - 1) / 2;

  a[k][k] = 1;                  // 数组中心

  for (i = 0; i < k; i++) {

    a[k + i][k + i + 1] = a[k + i][k + i] + 1;

    for (j = 0; j < 2 * i + 1; j++) // 向上

    {

      a[k + i - j - 1][k + i + 1] = a[k + i - j][k + i + 1] + 1;

    }

    for (j = 0; j < 2 * (i + 1); j++) // 向左

    {

      a[k - i - 1][k + i - j] = a[k - i - 1][k + i - j + 1] + 1;

    }

    for (j = 0; j < 2 * (i + 1); j++) // 向下

    {

      a[k - i + j][k - i - 1] = a[k - i + j - 1][k - i - 1] + 1;

    }

    for (j = 0; j < 2 * (i + 1); j++) // 向右

    {

      a[k + i + 1][k - i + j] = a[k + i + 1][k - i + j - 1] + 1;

    }

  }

  for (t = 0; t < n; t++)       // 显示数组

  {

    for (j = 0; j < n; j++) {

      printf("%d ", a[t][j]);

    }

    printf("\n");

  }

  for (i = 0, sum = 0; i < n; i++) // 对角线之和

  {

    sum = sum + a[i][i] + a[i][n - i - 1];

  }

  sum = sum - 1;

  printf("%d", sum);

  return 0;

}
