```cpp
#include<bits/stdc++.h>
using namespace std;
#define int long long

signed main(){
	int q,k;
	cin>>q>>k;

	priority_queue<int> pq;
	
	while(q--){
		int type;
		cin>>type;
		if(type==1){
			int x,y;
			cin>>x>>y;
			pq.push(x*x+y*y);
			if(pq.size() > k)
				pq.pop();
		}else{
			cout<< pq.top() <<"\n";
		}
	}

	return 0;
}
```