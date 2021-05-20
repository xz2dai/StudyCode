#include <stdio.h> 
//将n个圆盘从x柱子上借助y柱子移动到z柱子上 
 void move(int n, char x, char y, char z)    
 { 
      if(n == 1) 
        printf("圆盘编号 %d :From %c To %c\n",n,x,z); 
      else
      
      move(n-1,x,y,z);
         printf("圆盘编号 %d:From %c To %c\n",n,x,z);
         move(n-1,y,x,z);
} 
int main()
{
     //A,B,C分别代表三个柱子
     char ch1 = 'A';
     char ch2 = 'B';
     char ch3 = 'C';
 
     int n;   //n代表圆盘的个数
     printf("请输入圆盘的个数：");
     scanf("%d",&n);
     move(n,ch1,ch2,ch3);
    
     return 0;
}
