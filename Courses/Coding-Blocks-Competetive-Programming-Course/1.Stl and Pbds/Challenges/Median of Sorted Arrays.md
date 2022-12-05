```cpp
#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin>>n;
	vector<int> v;
	for(int i=0;i<2*n;++i){
		int x;
		cin>>x;
		v.push_back(x);
	}

	sort(begin(v),end(v));

	cout<< v[max(0,n-1)] <<endl;

	return 0;
}
```