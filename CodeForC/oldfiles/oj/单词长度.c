#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
    int i, n,j,sum=1;
    char word[21][10];
    while(1)
	{
		
	} 
    char cup[10];
    for (i = 1; i <= sum;i++)
    {
        for (j = 1; j <= sum;j++)
        {
            if(strlen(word[j])>strlen(word[j+1]))
            {
                strcpy(cup, word[j]);
                strcpy(word[j], word[j + 1]);
                strcpy(word[j + 1], cup);
            }
        }
    }
    for (i = 1; i <= sum;i++)
        printf("%s ", word[i]);
        system("pause");
    return 0;
}
