# LeetCode202

* Author：Wangshu Zhang
* Version：2020-04-01

# Problem: Happy Number

### Code
```Java
// Java Version
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = sumSquare(n);
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }
    private int sumSquare(int n) {
        String str = n + "";
        char[] arr = str.toCharArray();
        int sum = 0;
        for (char x : arr) {
            sum += (x - '0') * (x - '0');
        }
        return sum;
    }
}
```
