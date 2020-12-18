/*递归下降分析技术 P87例题4.15 测试串:i*i+i$#*/
#include <stdio.h>
#include<iostream>
using namespace std;
char a;
char lookahead;
char InString[100];
int i = 0, j, k, l, flag = -1,suc=1;

char getsymbol();
void error();
void match();
void E();
void E1();
void T();
void T1();
void F();

int main()
{
    while (1)
    { //读取输入程序
        scanf("%c", &a);
        if (a == '#')
            break;
        InString[i] = a;
        i++;
    }
    lookahead = getsymbol();
    E();
    if (lookahead == '$' && suc==1)
    {
        cout << "success!";
        return 0;
    }
    else
        error();
}

char getsymbol()
{
    char m = InString[++flag];
    return m;
}

void error()
{
    suc = 0;
    cout << "error!";
    //exit();
}
void error(char s[]){
    error();
    cout << s;
}

void match(char t)
{
    if (lookahead == t)
    {
        lookahead = getsymbol();
    }
    else
    {
        error();
    }
}

void E()
{
    T();
    E1();
}

void F()
{
    if (lookahead == 'i')
        match('i');
    else if (lookahead == '(')
    {
        match('(');
        E();
        if (lookahead == ')')
            match(')');
    }
    else
    {
        error();
    }
}

void E1()
{
    if (lookahead == '+')
    {
        match('+');
        T();
        E1();
    }else if(lookahead == '-'){
        match('-');
        T();
        E1();
    }
}

void T()
{
    F();
    T1();
}

void T1()
{
    if (lookahead == '*')
    {
        match('*');
        F();
        T1();
    }else if (lookahead == '/')
    {
        match('/');
        F();
        T1();
    }
}
