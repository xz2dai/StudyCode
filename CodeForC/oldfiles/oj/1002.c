 #include<stdio.h>              //这个题目要排序三个数组,冒泡失败了就上快排
 int main()                            //读入出错了
 {
     int a[4][6],n,i,k,cup;
     for(i=1;i<=3;i++)
     {
         for(k=1;k<=5;k++)          //读入
         {
             scanf("%d",&a[i][k]);
         }
         for (n=1; n<=5;n++)        //冒泡
         {
             for (k = 1; k <= 4; k++)
             {
                 if(a[i][k]>a[i][k+1])          //交换
                 {
                     cup=a[i][k];
                     a[i][k]=a[i][k + 1];
                     a[i][k + 1]=cup;
                 }
             }
         }
     }
     for (i = 1; i <= 3;i++)                    //输出
         {
             printf("%d\n",a[i][5]); 
         }
         return 0;
 }