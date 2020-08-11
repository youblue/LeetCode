# LeetCode274

* Author：Wangshu Zhang
* Version：2020-08-11

# Problem: H-Index

### Code
```Java
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int x : citations) {
            count[Math.min(n, x)] ++;
        }
        int i = n, sum = count[n];
        while (sum < i) {
            i --;
            sum += count[i];
        }
        return i;
    }
}
```
