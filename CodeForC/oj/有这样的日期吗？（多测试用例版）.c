#include<stdio.h>
int main()
{
    int n, i, k;
    scanf("%d", &n);
    for (i = 1; i <= n;i++)
    {
        int a,b,c;
    scanf("%d%d%d", &a, &b, &c);
    switch (b)
    {
        case 1:
            if(c>31){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 2:
        	if((a%4==0 && a%100!=0) || a%400==0)
        	{
        		if(c>29)
                    {
                        printf("no");
                        if (i != n)
                        printf("\n");
                        break;
                    }
                    
                    else
                    {
                        {
                             printf("yes");
                            if (i != n)
                            printf("\n");
                             break;
                        }
                    }
            }
            
            else
            {
                if(c>28){
                	printf("no");
                if (i != n)
                    printf("\n");
                	break;}
            	else{
                	printf("yes");
                if (i != n)
                    printf("\n");
                	break;}
            }
            
        case 3:
            if(c>31){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 5:
            if(c>31){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 7:
            if(c>31){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 8:
            if(c>31){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 10:
            if(c>31){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 12:
            if(c>31){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 4:
            if(c>30){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 6:
            if(c>30){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 9:
            if(c>30){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        case 11:
            if(c>30){
                printf("no");
                if (i != n)
                    printf("\n");
                break;}
            else{
                printf("yes");
                if (i != n)
                    printf("\n");
                break;}
        default:
        {
            printf("no");
                if (i != n)
                    printf("\n");
            break;
        }
    }
    }
}