#include<stdio.h>
int main() {
	char buffer;
	while (1) {
		scanf_s("%c", &buffer);
		if (buffer != 'c') {
			printf("error!");
			break;
		}
	}
	getchar();
	getchar();
	return 0;
}