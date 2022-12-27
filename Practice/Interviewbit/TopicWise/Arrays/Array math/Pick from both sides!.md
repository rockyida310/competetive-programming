[Problem](https://www.interviewbit.com/problems/pick-from-both-sides/)

---

```cpp
int Solution::solve(vector<int> &a, int b) {
    int n=a.size();
    //size of mid part = n-b
    int total_sum=0;
    for(int i=0;i<n;++i){
        total_sum += a[i];
    }
    
   
    vector<int> pr(n);
    for(int i=0;i<n;++i){
        if(i==0) pr[i]=a[i];
        else pr[i] = a[i]+pr[i-1];
    }
    
    int min_sum=INT_MAX;
    int l=-1;
    for(int r=n-b-1;r<n;++r){
        if(l==-1) min_sum=min(min_sum,pr[r]);
        else min_sum=min(min_sum,pr[r]-pr[l]);
        ++l;
    }
    
    return total_sum-min_sum;
}
```