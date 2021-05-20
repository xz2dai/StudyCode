//ц╟ещеепР
#include<stdio.h>
void bubblesort(int *a);
int main(){
    int a[8] = { 3, 12, 6, 6, 4, 7, 10, 1 };
    bubblesort(a);
    for (int i = 0; i < 8; i++)
    {
        printf("%d ", a[i]);
    }
        return 0;
}
void bubblesort(int *a){
    int n = sizeof(a);
    for (int i = 0; i < n;i++){
        for (int j = 0; j < n;j++){
            if(a[i]<a[j]){
                int m = a[j];
                a[j] = a[i];
                a[i] = m;
            }
        }
    }
}