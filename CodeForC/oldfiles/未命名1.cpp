#include<string>
#include<iostream>
using namespace std;
int main(){
    string x;
    int S,i;
    while(cin>>x>>S){
        while(S--){
            int len=x.length();
            for(i=0;i<len-1;)
                if(x[i]>x[i+1]){
                    x.erase(x.begin()+i);
                    break;
                }
                else i++;
            if(i==len-1)
                x.erase(x.begin()+i);
        }
        cout<<x<<endl;
    }
}