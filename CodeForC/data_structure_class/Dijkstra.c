#include<stdio.h>
#include<stdlib.h>

#define MAX 100
#define M 32767

int Creatcost(int cost[][MAX]){
    int vnum, anum, i, j, k, v1, v2, w;     
    printf("\n请输入顶点数和边数:");
    scanf("%d%d", &vnum, &anum);
    for (i = 0; i < vnum;i++){
        for (j = 0; j < vnum;j++){
            cost[i][j] = M;
        }
    }
    printf("请输入各边及其权值：");
    for (k = 0; k < anum;k++){
        printf("起点 终点 权值:");
        scanf("%d%d%d", &v1, &v2, &w);
        cost[v1][v2] = w;
    }
    return vnum;
}

void Dijkstra(int cost[][MAX],int n,int v){
    int dist[MAX], path[MAX], s[MAX];       
    //s[]记录顶点是否到了最短路径，dist[]表示当前求出的v0到v1的最短路径
    //path[]是路径数组,path[i]表示从源点到顶点vi之间最短路径上vi的前驱点
    int mindis, i, j, u, pre;       //mindis指最短距离
    for (i = 0; i < n;i++){
        dist[i] = cost[v][i];
        s[i] = 0;
        if(cost[v][i] < M){
            path[i] = v;
        }else{
            path[i] = -1;
        }
    }
    s[v] = 1;
    path[v] = 0;
    for (i = 0; i < n;i++){
        mindis = M;
        u = -1;
        for (j = 0; j < n;j++){
            if(s[j] == 0 && dist[j] < mindis){
                u = j;
                mindis = dist[j];
            }
        }
        if(u != -1){
            s[u] = 1;
            for (j = 0; j < n;j++){
                if (cost[u][j] < M && dist[u]+cost[u][j]<dist[j]){
                    dist[j] = dist[u] + cost[u][j];
                    path[j] = u;
                }
            }
        }
    }
    printf("\nDijkstra算法结果如下:");
    for (i = 0; i < n;i++){
        if(i!=v){
            printf("\n%d->%d:", v, i);
            if(s[i]==1){
                printf("路径长度为%2d", dist[i]);
                pre = i;
                printf("路线逆序为:");
                while(pre != v){
                    printf("%d,", pre);
                    pre = path[pre];
                }
                printf("%d", pre);
            }else{
                printf("不存在路径");
            }
        }
    }
}

int main(){
    int n;
    int cost[MAX][MAX];
    n = Creatcost(cost);
    Dijkstra(cost, n, 0);
    printf("\n");
    return 0;
}