#include <stdio.h>
int main() {
    int letter = 0, number = 0, other = 0;
    char c;
    printf("请输入字符以进行统计：\n");
    printf("提示：输入‘y’或‘Y’输出字母和数字个数，输入‘N’或‘n’输出其他字符个数\n");
    while((c = getchar()) != 'Y' && c != 'y' && c != 'N' && c != 'n') {
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            letter++;
        }

        else if(c >= '0' && c <= '9') {
            number++;
        }
        else {
            other++;
        }
    }

    if(c == 'Y' || c == 'y') {
        printf("字母和数字有%d个\n", number + letter);
    }
    else {
        printf("其他字符有%d个\n", other);
    }
    return 0;
}
