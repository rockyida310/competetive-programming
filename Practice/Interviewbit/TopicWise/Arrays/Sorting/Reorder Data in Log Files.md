[Problem](https://www.interviewbit.com/problems/reorder-data-in-log-files/)

---

```cpp
bool myCompare(const string &a,const string &b){
    int i = a.find('-');
    int j = b.find('-');
    
    if(!isdigit(a[i+1]) && !isdigit(b[j+1])){
        if(a.substr(i+1)==b.substr(j+1))
            return a<b;
        return a.substr(i+1) < b.substr(j+1);
    }else if(!isdigit(a[i+1]))
        return true;
    
    return false;
}
vector<string> Solution::reorderLogs(vector<string> &A) {
    stable_sort(begin(A),end(A),myCompare);
    return A;
}

```