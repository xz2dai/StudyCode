#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int i = 0,j=0,k,l,m,n;
char word_cache[20][20] = {"for", "if", "switch", "else", "case", "return", "int"};
char input_string[1000];	//输入的程序
char buffer_string[20];	//缓冲字符数组
char a;

char getNext(){
    char cc = input_string[j+1];
    return cc;
}
bool isNum(char c){
    if(c>='0' && c<='9')
        return true;
    return false;
}
bool isLetter(char c){
    if(c>='a' && c<='z')
        return true;
    return false;
}
bool isSymbol3(char c){
    if(c=='>'||c=='<'||c=='='||c=='-'||c=='+'||c=='*'||c=='/'){ //运算符
        return true;
    }
    return false;
}
bool isSymbol4(char c){
    if(c =='('||c==')'||c==','||c==';'){ //分界符
        return true;
    }
    return false;
}
int check(char c){
    memset(buffer_string, 0, 20); //清空缓冲数组
    if(isLetter(c)){
        char buffer[20];
        m = 0;
        buffer[m] = c;
        m++;
        char cc = getNext();
        while(isLetter(cc)){
            j++;
            buffer[m] = cc;
            m++;
            cc = getNext();
        }
        strcpy(buffer_string, buffer);
        for (n = 0; n < 20;n++){
            if(strcmp(buffer,word_cache[n])==0){
                return 1;
            }
        }
        return 2;
    }else if(isNum(c)){
        k=0;
        buffer_string[k] = c;
        k++;
        char cc = getNext();
        if(cc=='.'){
           j++;
           buffer_string[k] =cc;
           k++;
           cc = getNext();
           while(isNum(cc)){
            j++;
            buffer_string[k] = cc;
            k++;
            cc = getNext();
           }
           return 11;
        }else if(isNum(cc)){
            j++;
            buffer_string[k] =cc;
           k++;
           cc = getNext();
           while(isNum(cc)){
            j++;
            buffer_string[k] = cc;
            k++;
            cc = getNext();
           }
           return 10;
        }
        return 11;
    }else if(isSymbol3(c)){
        k=0;
        buffer_string[k] = c;
        k++;
        char cc = getNext();
        if(isSymbol3(cc)){
            j++;
            buffer_string[k] = cc;
            k++;
        }
        return 3;
    }else if(isSymbol4(c)){
        buffer_string[0] = c;
        return 4;
    }
    return 0;
}


int main(){

	while(1){	//读取输入程序
		scanf("%c",&a);
		if(a == '#') break;
		input_string[i] = a;
		i++;
	}
	for(j;j<i;j++){
		switch (check(input_string[j])){
		    case 1:{
		        printf("<1,'%s'>\n",buffer_string);
		        break;
            }
		    case 2:{
		        printf("<2,指向%s的符号表入口>\n",buffer_string);
		        break;
		    }
		    case 3:{
		        printf("<3,'%s'>\n",buffer_string);
		        break;
		    }
		    case 4:{
		        printf("<4,'%s'>\n",buffer_string);
		        break;
		    }
		    case 10:{
		        printf("<10,'%s'>\n",buffer_string);
		        break;
		    }
		    case 11:{
		        printf("<11,'%s'>\n",buffer_string);
		        break;
		    }
		    default:
                break;
		}
	}
	getchar();
	getchar();

}
