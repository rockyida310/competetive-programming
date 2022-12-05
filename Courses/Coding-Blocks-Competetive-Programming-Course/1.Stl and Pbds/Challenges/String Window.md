```cpp
#include<bits/stdc++.h>

using namespace std;

string smallestWindow(string s, string t) {
  vector < int > cnt1(256, 0), cnt2(256, 0);
  int token = 0;
  for (auto & c: t) {
    cnt1[c]++;
    if (cnt1[c] == 1) ++token;
  }

  int curr = 0;
  int res = (int) 1e6, resi = -1, l = 0;
  for (int r = 0; r < s.length(); ++r) {
    cnt2[s[r]]++;
    if (cnt1[s[r]] != 0 && cnt1[s[r]] == cnt2[s[r]])
      ++curr;

    while (l < r) {
      if (cnt2[s[l]] > cnt1[s[l]]) {
        cnt2[s[l]]--;
        l++;
      } else break;
    }

    if (curr == token && res > r - l + 1) {
      res = r - l + 1;
      resi = l;
    }
  }

  if (resi == -1) return "No String";
  return s.substr(resi, res);
}

int main() {
  string a, b;
  getline(cin, a);
  getline(cin, b);
  cout << smallestWindow(a, b);
  return 0;
}
```