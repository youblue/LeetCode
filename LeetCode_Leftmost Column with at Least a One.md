# LeetCode: A New Problem from Week3 of 30 Day Challenge

* Author：Wangshu Zhang
* Version：2020-04-21

# Problem: Leftmost Column with at Least a One
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/

### Code
```Java
// BinarySearch Solution According to Hint #1
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int res = -1;
        List<Integer> dim = binaryMatrix.dimensions();
        int n = dim.get(0), m = dim.get(1);
        for (int i = 0; i < n; i ++) {
            int start = 0, end = m - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (binaryMatrix.get(i, mid) == 0) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (binaryMatrix.get(i, end) != 0) {
                res = (res == -1 ? end : Math.min(res, end));
            }
        }
        return res;
    }
}
```

```Java
/* Optimal Approach according to Hint #2:

Imagine there is a pointer p(x, y) starting from top right corner.
p can only move left or down.
If the value at p is 0, move down.
If the value at p is 1, move left.
*/
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int n = dim.get(0), m = dim.get(1);
        int i = 0, j = m - 1;
        int res = -1;
        while (i < n && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                res = (res == -1 ? j : Math.min(res, j));
                j --;
            } else {
                i ++;
            }
        }
        return res;
    }
}
```
