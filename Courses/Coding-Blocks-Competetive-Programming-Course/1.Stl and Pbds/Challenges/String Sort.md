```cpp
#include<bits/stdc++.h>
    using namespace std;
 
    bool cmp(string &a,string &b){
        if(a.find(b)==0)
            return true;
        return a<b;
    }
 
    int main(){
        int n;
        cin>>n;
        vector<string> v(n);
        for(auto &c:v)
            cin>>c;
        sort(begin(v),end(v),cmp);
        for(auto &c:v)
            cout<<c<<"\n";
 
        return 0;
    }
```

---

```cpp
#include<bits/stdc++.h>
using namespace std;

bool cmp(string &a,string &b){
	if(a.find(b)!=string::npos)
		return true;
	return a<b; 
}

int main(){
	int n;
	cin>>n;
	vector<string> v(n);
	for(auto &c:v)
		cin>>c;
	sort(begin(v),end(v),cmp);
	for(auto &c:v)
		cout<<c<<"\n";

	return 0;
}
```