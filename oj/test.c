#include <stdio.h>
#include <string.h>

int main()
{
	char s1[1001], s2[1001];
	gets(s1);
	gets(s2);
	if (strcmp(s1, s2) > 0) {
		printf("s1��s2��");
		return 0;
	}
	if (strcmp(s1, s2)==0) {
		printf("s1��s2��ͬ");
		return 0;
	}
	if (strcmp(s1, s2)<0) {
		printf("s1��s2С");
		return 0;
	}	
}