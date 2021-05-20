#include<stdio.h>

#define INF 99


int map[5][5], dij[5], book[5];

void Dijkstra(){

    
}

int main(int argc,char **args){
    int  i, j, k,origin, x, y, z;

    //初始化map
    ///*
    for (i = 0 ; i < 5; i++)
        for (j = 0; j < 5;j++)
            map[i][j] = INF;
    for (i = 0; i < 10;i++)
        map[i][i] = 0;

    //输入图,这里直接在代码里写明省事
    map = {0,5,10,7,INF,
            5,0,INF,INF,20,
            10,INF,0,8,6,
            7,INF,8,0,3,
            INF,20,6,3,0
        }
    
}

