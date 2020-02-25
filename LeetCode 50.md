# LeetCode50

* Author：Wangshu Zhang
* Version：2020-02-25

# Problem: Pow(x, n)

# Thoughts
* The intuitive way is case-by-case discussion. There are following cases:
  * If n == 0: return 1
  * If n == 1: return x
  * If n == -1: return 1 / x
  * If n % 2 == 0: return Pow(x * x, n / 2)
  * Else if n > 0: return Pow(x * x, n / 2) * x
  * Else: return Pow(x * x, n / 2) / x


* LeetCode also provides a lot of solutions:
https://leetcode.com/problems/powx-n/solution/

### Code
```Java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else if (n > 0) {
            return myPow(x * x, n / 2) * x;
        } else {
            return myPow(x * x, n / 2) / x;
        }
    }
}
```



# Summary
* This problem is a little boring because Java has the method Math.pow() for this.
