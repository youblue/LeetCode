# LeetCode55

* Author：Wangshu Zhang
* Version：2020-04-24

# Problem: Jump Game

### Code

```Java
// My solution
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (dp[0] == 0) {
            return false;
        }
        for (int i = 1; i < n - 1; i ++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
```

```Java
// Greedy: O(n)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int lastPos = nums.length - 1;
        for (int i = lastPos; i >= 0; i --) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
```
