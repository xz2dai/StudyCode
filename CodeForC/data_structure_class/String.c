
/*
    Author:袁铨
    Topic:串
    DATA:2019-10-27
*/
#include <stdio.h>
#define  MAXSIZE  100      /*顺序串存储空间的总分配量*/
typedef  struct            /*串结构定义*/
{
    char ch[MAXSIZE];
    int Len;
}String;

int StrLength(String *S)
{  /*求串长度函数*/
   int i=0;
   while(S->ch[i]!='\0')
      i++;
   S->Len=i;
   return (S->Len);
}

void CreatStr(String *S)
{   /*建立一个新串*/
	gets(S->ch);
	S->Len=StrLength(S);
}

int SubString(String *S,String *Sub,int pos,int len)
{   /*求子串函数*/
    int j;
    if(pos<1 || pos>S->Len || len<1 || len>S->Len-pos+1)
    {
       Sub->Len=0;
       printf("参数错误!\n");
       return 0;
    }
    else
    {
    for(j=0;j<len;j++)
        Sub->ch[j]=S->ch[pos+j-1];
    Sub->ch[j]='\0';
    Sub->Len=len;
    return 1;
    }
}

int  StrDelete(String *S,int i,int l)
{   /*在串s中删除从指定位置i开始连续的j个字符*/
	int k;
	if(i+l-1>S->Len)
	{   printf("所要删除的子串超界！");
		return 0;
	}
	else
	{
		for(k=i+l-1;k<S->Len;k++,i++)
		   S->ch[i-1]=S->ch[k];
		S->Len=S->Len-l;
		S->ch[S->Len]='\0';
		return 1;
	}
}

int StrInsert(String *S,String *S1,int i)
{   /*在串s中插入子串s1函数*/
	int k;
	if(i>S->Len+1)
	{   printf("插入位置错误！");
		return 0;
	}
	else if(S->Len+S1->Len>MAXSIZE)
	{   printf("两串长度超过存储空间长度！");
		return 0;
	}
	else
	{  for(k=S->Len-1;k>=i-1;k--)
		  S->ch[S1->Len+k]=S->ch[k];
	   for(k=0;k<S1->Len;k++)
	      S->ch[i+k-1]=S1->ch[k];
	   S->Len=S->Len+S1->Len;
	   S->ch[S->Len]='\0';
	   return  1;
	}
}

int StrIndex(String *S,String *T)
{   /*串的定位函数*/
    int i=0,j=0,k;
    while(i<S->Len && j<T->Len)
    {
	if(S->ch[i]==T->ch[j])
        {
            i++;
            j++;
        }
        else
        {
            i=i-j+1;
            j=0;
        }
    }
    if(j>=T->Len)
        k=i-T->Len+1;
    else
        k=-1;
    return k;
}

int StrCompare(String *S1,String *S2)
{   /*两个串判断是否相等*/
	int i=0,flag=0;
	while(S1->ch[i]!='\0'&&S2->ch[i]!='\0')
	{	if(S1->ch[i]!=S2->ch[i])
		{  flag=1;	break; }	 
		else
		   i++;
	} 
	if (flag==0 && S1->Len==S2->Len)   /*两串长度相同且所有字符都相同，两串相等*/
	   return  0;
	else
	   return  S1->ch[i]-S2->ch[i];
}
		
int StrCat(String *S, String *T)
{   /*串的连接函数*/
    int i, flag;/*将串T连接在串S的后面*/
    if(S->Len+T->Len<=MAXSIZE)  /*连接后串长小于MAXLEN*/
    {
        for(i=S->Len; i<S->Len+T->Len;i++)
            S->ch[i]=T->ch[i-S->Len];
        S->ch[i]='\0';
        S->Len+=T->Len;
	    flag=1;
    }
    else if(S->Len<MAXSIZE)
    {  /*连接后串长大于MAXLEN，但串S的长度小于MAXLEN，即连接后串T的部分字符序列被舍弃*/
       for(i=S->Len;i<MAXSIZE;i++)
	      S->ch[i]=T->ch[i-S->Len];
       S->Len=MAXSIZE;      
       flag=0;
    }
    else 
       flag=0;  /*串S的长度等于MAXLEN ,串T不被连接*/
    return(flag);
}

void StrReplace(String *S,String *T,String *V)
{   /*子串替换函数*/
	int i,m,n,p,q;
	n=S->Len;
	m=T->Len;
	q=V->Len;
	p=1;
	do
	{
	   i=StrIndex(S,T);   /*调用定位函数得到子串T在主串S的位置*/
	   if(i!=-1)          /*当主串S中有该子串T时*/
	   {
	   	   StrDelete(S,i,m); /*调用删除子串函数删除该子串T*/
	   	   StrInsert(S,V,i);  /*调用插入子串函数插入子串V*/
	   	   p=i+q;
	   	   S->Len=S->Len+q-m;  /*修改主串S的长度*/
	   	   n=S->Len;
	   }
	}while((p<=n-m+1)&&(i!=-1));
}

void  MenuString()                                    
{   /*显示菜单子函数*/
	printf("\n                     串系统");
    printf("\n|               1——建立新串并显示该串及长度    |");
    printf("\n|               2——求子串                      |");
    printf("\n|               3——删除子串                    |");
    printf("\n|               4——插入子串                    |");
    printf("\n|               5——查找子串                    |");
    printf("\n|               6——比较两个串大小              |");   
    printf("\n|               7——连接两个串                  |"); 
    printf("\n|               8——子串替换                    |");  
    printf("\n|               0——返回                        |");
    printf("\n请输入菜单号（0-8）:"); 	
}

main()
{
   int i,len,flag;
   String  x,y,z;
   String *S=&x,*S1=&y,*S2=&z; 
   char  ch1,ch2,a;
   ch1='y';
   while(ch1=='y'||ch1=='Y') 
   {  MenuString();
   	  scanf("%c",&ch2);
   	  getchar();
   	  switch(ch2)
   	  {
   	  	 case  '1':   	  	 
             printf("请输入一个字符串：");
             CreatStr(S);
             printf("该串值为：");
             if(S->ch[0]=='\0')
                printf("空串");
             else
             {   puts(S->ch);
             	 printf("该串的长度为：%d",S->Len);
             }
             break;
          case  '2':
             printf("请输入从第几个字符开始求子串：");
             scanf("%d",&i);
             printf("请输入取出的子串长度：");
             scanf("%d",&len);
             flag=SubString(S,S1,i,len);
             if(flag)
             {   printf("求子串成功，原来主串为：");
             	 puts(S->ch);
             	 printf("所得子串为：");
                 puts(S1->ch);
             }
             else
                 printf("求子串失败！");
             break;
         case  '3':
             printf("请输入要删除的子串的起始位置：");
             scanf("%d",&i);
             printf("请输入要删除的子串的长度：");
             scanf("%d",&len);
             printf("原来串为：");
             puts(S->ch);
             if(flag=StrDelete(S,i,len))
             {   printf("删除子串成功，删除后的新的串为：");
                puts(S->ch);
   	         }
             else
                printf("删除子串失败！");
             break;
         case  '4':
             printf("请输入要插入子串在主串中的位置：");
             scanf("%d",&i);
             printf("请输入一个子串：");getchar();
             CreatStr(S1);
             printf("原来主串为：");
             puts(S->ch);
             if(flag=StrInsert(S,S1,i))
             {  printf("插入子串成功！插入后的新的主串为：");
             	puts(S->ch);
             }
             else
                printf("插入子串失败！");
             break;
         case  '5':
             printf("请输入第一个串：");
             CreatStr(S);
             printf("请输入第二个串：");
             CreatStr(S1);
             i=StrIndex(S,S1);
             if(i==-1)
                printf("查找失败，主串中没有该子串！");
             else
                printf("查找成功，该子串在主串中第一次出现的位置为%d。",i);
             break;
         case  '6':    
             printf("请输入第一个串：");
             CreatStr(S);
             printf("请输入第二个串：");
             CreatStr(S1);
             flag=StrCompare(S,S1);
             if(flag>0)
                printf("第一个串大！");
             else if(flag<0)	
                printf("第二个串大！");
             else
                printf("两个串相等！");
             break;
         case  '7':
             printf("请输入第一个串：");
             CreatStr(S);
             printf("请输入第二个串：");
             CreatStr(S1);
             flag=StrCat(S,S1);
             if(flag)
             {   printf("连接以后的新串值为：");
                 puts(S->ch);
             }
             else 
                 printf("连接失败！");
             break;
         case  '8':
             printf("请输入主串：");
             CreatStr(S);
             printf("请输入在主串查找的子串：");
             CreatStr(S1);
             printf("请输入要替换的子串：");
             CreatStr(S2);
             StrReplace(S,S1,S2);
             printf("替换后的主串为：");
             puts(S->ch);
             break;
         case  '0':
             ch1='n';
             break;
         default:
             printf("输入有误，请输入0-9进行选择！");
   	  }
   	  if(ch2!='0')
   	  {   printf("\n按回车键继续，按任意键返回主菜单！\n");
   	  	  a=getchar();
   	  	  if(a!='\xA')
   	  	  {
   	  	  	 getchar();ch1='n';
   	  	  }
   	  }
   }
}

