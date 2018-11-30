#include <stdio.h>
#include <string.h>

int main()
{
	char s1[1001], s2[1001];
	gets(s1);
	gets(s2);
	if (strcmp(s1, s2) > 0) {
		printf("s1比s2大");
		return 0;
	}
	if (strcmp(s1, s2)==0) {
		printf("s1与s2相同");
		return 0;
	}
	if (strcmp(s1, s2)<0) {
		printf("s1比s2小");
		return 0;
	}	
}