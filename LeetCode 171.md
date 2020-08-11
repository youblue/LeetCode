# LeetCode171

* Author：Wangshu Zhang
* Version：2020-08-11

# Problem: Excel Sheet Column Number

### Code
```Java
class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i ++) {
            char c = s.charAt(i);
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}
```
