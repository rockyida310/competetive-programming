```cpp
#include<bits/stdc++.h>
using namespace std;

int main(){
	int n,k;
	cin>>n>>k;

	vector<int> val(n) , pos(n+1);
	for(int i=0;i<n;++i){
		cin>>val[i];
		pos[val[i]] = i;
	}

	for(int i=0;i<n;++i){
		if(k && n-i != val[i]){
			int x = val[i];
			val[i] = n-i;
			val[pos[n-i]] = x;
			pos[x] = pos[n-i];
			pos[n-i] = i;
			--k;
		}
		cout<< val[i] <<" ";
	}
	


	return 0;
}
```