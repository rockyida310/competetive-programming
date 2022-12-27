/*
 * A.cpp
 *
 *  Created on: 03-Dec-2022
 *      Author: dedic
 */

#include<bits/stdc++.h>
using namespace std;
#define endl "\n"
#define pii pair<int,int>

class Solution{
	public:
	void solve(){

	}

	private:
	const int mod = 1000000007;
	struct Mint
	{
	    int val;
	    Mint(int _val = 0)
	    {
	        val = _val % mod;
	    }
	    Mint(long long _val = 0)
	    {
	        val = _val % mod;
	    }
	    Mint operator+(Mint oth)
	    {
	        return val + oth.val;
	    }
	    Mint operator*(Mint oth)
	    {
	        return 1LL * val * oth.val;
	    }
	    Mint operator-(Mint oth)
	    {
	        return val - oth.val + mod;
	    }
	    void operator+=(Mint oth)
	    {
	        val = (Mint(val) + oth).val;
	    }
	    void operator-=(Mint oth)
	    {
	        val = (Mint(val) - oth).val;
	    }
	    void operator*=(Mint oth)
	    {
	        val = (Mint(val) * oth).val;
	    }
	};

};


signed main (void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    Solution obj;

    int tc=1;
    cin>>tc;
    for(int ctc=1;ctc<=tc;++ctc){
         // cout<<"Case #"<<ctc<<": ";
         obj.solve();
         // if(ctc!=tc) cout<<endl;
    }
    return 0;
}


