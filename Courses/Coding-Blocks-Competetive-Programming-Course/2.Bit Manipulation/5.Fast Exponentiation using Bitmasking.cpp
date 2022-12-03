#include "bits/stdc++.h"
using namespace std;

int power_optimised(int a,int n){
    int ans = 1;

    while(n>0){
        int last_bit = (n&1);
        if(last_bit){
            ans = ans * a;
        }
        a = a*a;
        n = n>>1;
    }

    return ans;
}

int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(auto &c:arr)
        cin>>c;
    int res = uniqueNumber3(arr);
    cout<<res<<"\n";
    return 0;
}