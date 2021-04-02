# LeetCode1133

* Author：Wangshu Zhang
* Version：2021-04-02

# Problem: Largest Unique Number

### Code
```Java
class Solution {
    public int largestUniqueNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] count = new int[1001];
        for (int x : A) {
            count[x] ++;
        }
        for (int i = count.length - 1; i >= 0; i --) {
            if (count[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
```
