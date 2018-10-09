#include<stdio.h>
int main(int argc, char* args[])
{
	int n,i,all_number=0;
	char ch;
	scanf("%d", &n);
	int number[n];
	float grade[n], totla[n],last,all_totla=0;
	for (i = 0; i < n; i++)
	{
		scanf("%d %f", &number[i], &grade[i]);
		totla[i] += number[i] * grade[i];
		all_number+=number[i];
	}
	printf("%f %f\n",all_number,all_totla);
	last = all_totla / (float)all_number;
	printf("%.2f", last);
	return 0;
}
