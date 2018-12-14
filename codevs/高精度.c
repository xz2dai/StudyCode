#include<stdio.h>
#include<string.h>
int main()
{ 
 char a[100001],b[100001];
 int a1[100001]={0},b1[100001]={0},s[200002]={0};
 int lena,lenb;
 int i,j,k=0,t;
 scanf("%s%s",a,b);
 lena=strlen(a);
 lenb=strlen(b);
 for(i=0;i<lena;i++)
    a1[i]=a[i]-48;
 for(j=0;j<lenb;j++)
    b1[j]=b[j]-48;
 while(i>=0&&j>=0)
 {
  s[k]=a1[i]+b1[j];
  k++;
  i--;
  j--;
 }
 if(i>=0)
 while(i>=0)
 {
  s[k]=a1[i];
  k++;
  i--;
 }
 else if(j>=0)
 while(j>=0)
 {
  s[k]=b1[j];
  k++;
  j--;
 }
 for(t=1;t<k;t++)
 if(s[t]>=10){s[t]%=10;s[t+1]++;}
 while(s[k]==0)
    k--;
 for(t=k;t>0;t--)
    printf("%d",s[t]);
 return 0;
}
