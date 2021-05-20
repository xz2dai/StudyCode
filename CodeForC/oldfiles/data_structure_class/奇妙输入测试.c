#include<stdio.h>
int main(){
    char buffer = ' ';
    int a = 0;
    char string[100];
    gets(string);
    while(1){          //最终妥协
        buffer = string[a];
        if(buffer == '\0'){
            printf("done");
            break;
        }
        if(buffer != 'c'){
            printf("error at %d!",a);
            break;
        }
        a++;
    }
    return 0;
}