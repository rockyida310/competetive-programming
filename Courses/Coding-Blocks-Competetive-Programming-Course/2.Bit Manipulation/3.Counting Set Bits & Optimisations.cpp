#include "bits/stdc++.h"
using namespace std;

int countBits(int n){
    int ans = 0;
    while(n > 0){
        ans += (n&1);
        n = n>>1;
    }
    return ans;
    // Time Complexity : O(logN+1)
}

int countBitsFast(int n){
    int ans = 0;
    while(n > 0){
        n = n&(n-1);
        ans++;
    }
    return ans; 
    // Time Complexity : O(no of set bits)
}

int countBitsUsingInbuiltMethod(int n){
    return __builtin_popcount(n);
}

int main(){
    int n;
    cin>>n;
    cout<< countBits(n) <<"\n";
    return 0;
}