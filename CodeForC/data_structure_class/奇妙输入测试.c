#include<stdio.h>
int main(){
    char buffer, a, b, c;
    while(1){
        buffer = getchar();
        if(buffer != 'c'){
            printf("error!");
            break;
        }
    }
    return 0;
}