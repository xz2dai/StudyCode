#include <iostream>
#include <chrono>
#include <cstdio>
#include<cstdlib>
int main(int argc,char* args[])
{
	int a[11]={9,5,4,6,7,3,2,1,10,8};
	int i,j,cup;
	auto start = std::chrono::steady_clock::now();
	for(i=0;i<10;i++)
	{
		for(j=0;j<10;j++)
	{
			if(a[i]>a[j])
				{
					cup=a[i];
					a[i]=a[j];
					a[j]=cup;
				}
	}
	}
	for(i=0;i<10;i++)
		std::cout<<a[i];	
    std::cout<<" ";							
	auto end = std::chrono::steady_clock::now();
	std::chrono::duration<double>diff = end-start;
	std::cout<<std::fixed<<diff.count()<<" s"<<std::endl;           //.count输出好像是double类型
	return 0;
}