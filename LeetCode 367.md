# LeetCode367

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-08

# Problem: Valid Perfect Square

### Code
```Java
// Yili
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (i <= num / i) {
            if (i * i == num) {
                return true;
            }
            i++;
        }
        return false;
    }
}
```

```Java
// Wangshu
class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1, end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid < num / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
```
