# LeetCode201

* Author：Yili Zhao
* Version：2020-04-23

# Problem: Bitwise AND of Numbers Range

### Code
```Java
class Solution {
    public int rangeBitwiseAnd(int m, int n) {

      /* Count number of bits for n
         ex: n = 9 = (1001)_2
         bits = 4
         x = 8 = (1000)_2
      */
        int res = 0;
        int temp = n;
        int bits = 1;
        int x = 1; // The highest bit is 1, all the other bits are 0
        while (temp > 1) {
            bits++;
            temp = temp >> 1;
            x = x << 1;
        }

        /* Align all numbers between [m, n],
           from highest bit to lowest bit,
           discuss 3 scenarios:
           (1) if x <= m, which means the current bits are all 1.
               Then add x to result, and keep comparing the remaining bits.
           (2) if x > m and x <= n, which means the current bit have both 0 and 1.
               Then no need to compare other lower bits because the product will be all 0
           (3) if x > n, do nothing but x / 2 (right shift 1 bit).
        */
        while (x >= 1) {
            if (m >= x && n >= x) {
                res += x;
                m = m - x;
                n = n - x;
            } else if (m < x && n >= x) {
                break;
            }
            x = x >> 1;
        }
        return res;
    }
}
```
