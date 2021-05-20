
/*
    Author:Ԭ��
    Topic:��
    DATA:2019-10-27
*/
#include <stdio.h>
#define  MAXSIZE  100      /*˳�򴮴洢�ռ���ܷ�����*/
typedef  struct            /*���ṹ����*/
{
    char ch[MAXSIZE];
    int Len;
}String;

int StrLength(String *S)
{  /*�󴮳��Ⱥ���*/
   int i=0;
   while(S->ch[i]!='\0')
      i++;
   S->Len=i;
   return (S->Len);
}

void CreatStr(String *S)
{   /*����һ���´�*/
	gets(S->ch);
	S->Len=StrLength(S);
}

int SubString(String *S,String *Sub,int pos,int len)
{   /*���Ӵ�����*/
    int j;
    if(pos<1 || pos>S->Len || len<1 || len>S->Len-pos+1)
    {
       Sub->Len=0;
       printf("��������!\n");
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
{   /*�ڴ�s��ɾ����ָ��λ��i��ʼ������j���ַ�*/
	int k;
	if(i+l-1>S->Len)
	{   printf("��Ҫɾ�����Ӵ����磡");
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
{   /*�ڴ�s�в����Ӵ�s1����*/
	int k;
	if(i>S->Len+1)
	{   printf("����λ�ô���");
		return 0;
	}
	else if(S->Len+S1->Len>MAXSIZE)
	{   printf("�������ȳ����洢�ռ䳤�ȣ�");
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
{   /*���Ķ�λ����*/
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
{   /*�������ж��Ƿ����*/
	int i=0,flag=0;
	while(S1->ch[i]!='\0'&&S2->ch[i]!='\0')
	{	if(S1->ch[i]!=S2->ch[i])
		{  flag=1;	break; }	 
		else
		   i++;
	} 
	if (flag==0 && S1->Len==S2->Len)   /*����������ͬ�������ַ�����ͬ���������*/
	   return  0;
	else
	   return  S1->ch[i]-S2->ch[i];
}
		
int StrCat(String *S, String *T)
{   /*�������Ӻ���*/
    int i, flag;/*����T�����ڴ�S�ĺ���*/
    if(S->Len+T->Len<=MAXSIZE)  /*���Ӻ󴮳�С��MAXLEN*/
    {
        for(i=S->Len; i<S->Len+T->Len;i++)
            S->ch[i]=T->ch[i-S->Len];
        S->ch[i]='\0';
        S->Len+=T->Len;
	    flag=1;
    }
    else if(S->Len<MAXSIZE)
    {  /*���Ӻ󴮳�����MAXLEN������S�ĳ���С��MAXLEN�������Ӻ�T�Ĳ����ַ����б�����*/
       for(i=S->Len;i<MAXSIZE;i++)
	      S->ch[i]=T->ch[i-S->Len];
       S->Len=MAXSIZE;      
       flag=0;
    }
    else 
       flag=0;  /*��S�ĳ��ȵ���MAXLEN ,��T��������*/
    return(flag);
}

void StrReplace(String *S,String *T,String *V)
{   /*�Ӵ��滻����*/
	int i,m,n,p,q;
	n=S->Len;
	m=T->Len;
	q=V->Len;
	p=1;
	do
	{
	   i=StrIndex(S,T);   /*���ö�λ�����õ��Ӵ�T������S��λ��*/
	   if(i!=-1)          /*������S���и��Ӵ�Tʱ*/
	   {
	   	   StrDelete(S,i,m); /*����ɾ���Ӵ�����ɾ�����Ӵ�T*/
	   	   StrInsert(S,V,i);  /*���ò����Ӵ����������Ӵ�V*/
	   	   p=i+q;
	   	   S->Len=S->Len+q-m;  /*�޸�����S�ĳ���*/
	   	   n=S->Len;
	   }
	}while((p<=n-m+1)&&(i!=-1));
}

void  MenuString()                                    
{   /*��ʾ�˵��Ӻ���*/
	printf("\n                     ��ϵͳ");
    printf("\n|               1���������´�����ʾ�ô�������    |");
    printf("\n|               2�������Ӵ�                      |");
    printf("\n|               3����ɾ���Ӵ�                    |");
    printf("\n|               4���������Ӵ�                    |");
    printf("\n|               5���������Ӵ�                    |");
    printf("\n|               6�����Ƚ���������С              |");   
    printf("\n|               7��������������                  |"); 
    printf("\n|               8�����Ӵ��滻                    |");  
    printf("\n|               0��������                        |");
    printf("\n������˵��ţ�0-8��:"); 	
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
             printf("������һ���ַ�����");
             CreatStr(S);
             printf("�ô�ֵΪ��");
             if(S->ch[0]=='\0')
                printf("�մ�");
             else
             {   puts(S->ch);
             	 printf("�ô��ĳ���Ϊ��%d",S->Len);
             }
             break;
          case  '2':
             printf("������ӵڼ����ַ���ʼ���Ӵ���");
             scanf("%d",&i);
             printf("������ȡ�����Ӵ����ȣ�");
             scanf("%d",&len);
             flag=SubString(S,S1,i,len);
             if(flag)
             {   printf("���Ӵ��ɹ���ԭ������Ϊ��");
             	 puts(S->ch);
             	 printf("�����Ӵ�Ϊ��");
                 puts(S1->ch);
             }
             else
                 printf("���Ӵ�ʧ�ܣ�");
             break;
         case  '3':
             printf("������Ҫɾ�����Ӵ�����ʼλ�ã�");
             scanf("%d",&i);
             printf("������Ҫɾ�����Ӵ��ĳ��ȣ�");
             scanf("%d",&len);
             printf("ԭ����Ϊ��");
             puts(S->ch);
             if(flag=StrDelete(S,i,len))
             {   printf("ɾ���Ӵ��ɹ���ɾ������µĴ�Ϊ��");
                puts(S->ch);
   	         }
             else
                printf("ɾ���Ӵ�ʧ�ܣ�");
             break;
         case  '4':
             printf("������Ҫ�����Ӵ��������е�λ�ã�");
             scanf("%d",&i);
             printf("������һ���Ӵ���");getchar();
             CreatStr(S1);
             printf("ԭ������Ϊ��");
             puts(S->ch);
             if(flag=StrInsert(S,S1,i))
             {  printf("�����Ӵ��ɹ����������µ�����Ϊ��");
             	puts(S->ch);
             }
             else
                printf("�����Ӵ�ʧ�ܣ�");
             break;
         case  '5':
             printf("�������һ������");
             CreatStr(S);
             printf("������ڶ�������");
             CreatStr(S1);
             i=StrIndex(S,S1);
             if(i==-1)
                printf("����ʧ�ܣ�������û�и��Ӵ���");
             else
                printf("���ҳɹ������Ӵ��������е�һ�γ��ֵ�λ��Ϊ%d��",i);
             break;
         case  '6':    
             printf("�������һ������");
             CreatStr(S);
             printf("������ڶ�������");
             CreatStr(S1);
             flag=StrCompare(S,S1);
             if(flag>0)
                printf("��һ������");
             else if(flag<0)	
                printf("�ڶ�������");
             else
                printf("��������ȣ�");
             break;
         case  '7':
             printf("�������һ������");
             CreatStr(S);
             printf("������ڶ�������");
             CreatStr(S1);
             flag=StrCat(S,S1);
             if(flag)
             {   printf("�����Ժ���´�ֵΪ��");
                 puts(S->ch);
             }
             else 
                 printf("����ʧ�ܣ�");
             break;
         case  '8':
             printf("������������");
             CreatStr(S);
             printf("���������������ҵ��Ӵ���");
             CreatStr(S1);
             printf("������Ҫ�滻���Ӵ���");
             CreatStr(S2);
             StrReplace(S,S1,S2);
             printf("�滻�������Ϊ��");
             puts(S->ch);
             break;
         case  '0':
             ch1='n';
             break;
         default:
             printf("��������������0-9����ѡ��");
   	  }
   	  if(ch2!='0')
   	  {   printf("\n���س�����������������������˵���\n");
   	  	  a=getchar();
   	  	  if(a!='\xA')
   	  	  {
   	  	  	 getchar();ch1='n';
   	  	  }
   	  }
   }
}

