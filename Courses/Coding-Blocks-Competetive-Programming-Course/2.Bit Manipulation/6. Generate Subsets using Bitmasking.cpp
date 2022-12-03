    
    #include "bits/stdc++.h"
    using namespace std;

    //print all subsequences
    void filterChars(string s,int mask){
        int j = 0;
        while(mask > 0){
            int last_bit = (mask&1);
            if(last_bit == 1){
                cout<<s[j];
            }
            ++j;
            mask = mask>>1;
        }
    }

    void printSubsets(string s){
        int n = s.length();
        for(int i=0;i<(1<<n);++i){
            filterChars(s,i);
            cout<<endl;
        }   
        return;
    }

    int main(){
        string s;
        cin>>s;
        printSubsets(s);
        return 0;
    }