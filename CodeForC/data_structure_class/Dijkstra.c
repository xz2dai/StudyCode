#include<stdio.h>
#include<stdlib.h>

#define MAX 100
#define M 32767

int Creatcost(int cost[][MAX]){
    int vnum, anum, i, j, k, v1, v2, w;     
    printf("\n�����붥�����ͱ���:");
    scanf("%d%d", &vnum, &anum);
    for (i = 0; i < vnum;i++){
        for (j = 0; j < vnum;j++){
            cost[i][j] = M;
        }
    }
    printf("��������߼���Ȩֵ��");
    for (k = 0; k < anum;k++){
        printf("��� �յ� Ȩֵ:");
        scanf("%d%d%d", &v1, &v2, &w);
        cost[v1][v2] = w;
    }
    return vnum;
}

void Dijkstra(int cost[][MAX],int n,int v){
    int dist[MAX], path[MAX], s[MAX];       
    //s[]��¼�����Ƿ������·����dist[]��ʾ��ǰ�����v0��v1�����·��
    //path[]��·������,path[i]��ʾ��Դ�㵽����vi֮�����·����vi��ǰ����
    int mindis, i, j, u, pre;       //mindisָ��̾���
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
    printf("\nDijkstra�㷨�������:");
    for (i = 0; i < n;i++){
        if(i!=v){
            printf("\n%d->%d:", v, i);
            if(s[i]==1){
                printf("·������Ϊ%2d", dist[i]);
                pre = i;
                printf("·������Ϊ:");
                while(pre != v){
                    printf("%d,", pre);
                    pre = path[pre];
                }
                printf("%d", pre);
            }else{
                printf("������·��");
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