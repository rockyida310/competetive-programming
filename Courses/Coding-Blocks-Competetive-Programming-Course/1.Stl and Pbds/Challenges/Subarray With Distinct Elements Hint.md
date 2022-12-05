```cpp
#include<bits/stdc++.h>
using namespace std;

int sumoflength(int arr[], int n){
        unordered_map<int,int> cnt;
        int ans = 0 , l = 0;
        for(int r=0;r<n;++r){
            cnt[arr[r]]++;
            while(cnt[arr[r]]>1){
                cnt[arr[l]]--;
                ++l;
            }
            ans += (r-l+1)*(r-l+2) / 2;
        }
        
        return ans;
    }

int main(){
	int n;
	cin>>n;
	int arr[n];
	for(int i=0;i<n;++i)
		cin>>arr[i];
	cout<< sumoflength(arr , n) <<endl;
	return 0;
}
```