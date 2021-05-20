//÷±Ω”≤Â»Î≈≈–Ú
#include<stdio.h>
void insertsort(int *a);
int main(){
    int a[8] = { 3, 12, 6, 6, 4, 7, 10, 1 };
    insertsort(a);
    for (int i = 0; i < 8; i++)
    {
        printf("%d ", a[i]);
    }
        return 0;
}
void insertsort(int *a){
    int n = sizeof(a);
    if(n<2)
        return;
    int tmp,i,j;
    for (i = 0; i < n;i++){
        tmp = a[i];
        for (j = i - 1; j >= 0 && tmp < a[j];j--){
            a[j + 1] = a[j];
        }
        a[j + 1] = tmp;
    }
}