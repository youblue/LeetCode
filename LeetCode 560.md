# LeetCode560

* Author：Wangshu Zhang
* Version：2020-04-22

# Problem: Subarray Sum Equals K

### Code
```Java
// My O(n^2) solution
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        dp[0] = nums[0];
        if (dp[0] == k) {
            res ++;
        }
        for (int i = 1; i < n; i ++) {
            dp[i] = dp[i - 1] + nums[i];
            if (dp[i] == k) {
                res ++;
            }
        }
        for (int i = 1; i < n; i ++) {
            for (int j = i; j < n; j ++) {
                int sum = dp[j] - dp[i - 1];
                if (sum == k) {
                    res ++;
                }
            }
        }
        return res;
    }
}
```

```Java
// HashMap O(n) solution
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
```
