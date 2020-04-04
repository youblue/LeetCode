# LeetCode53

* Author：Wangshu Zhang
* Version：2020-04-03

# Problem: Maximum Subarray

### Code
```Java
// Greedy: Time O(n), Space O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
```

```Java
// Dynamic Programming: Time O(n), Space O(1)
// Definition of nums[i]: till nums[i] the maximal sum
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }
}
```

```Java
// Divide and Conquer:
// Really don't think Divide and Conquer is a good method for this question
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return max(nums, 0, nums.length - 1);
    }
    private int max(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftMax = max(nums, left, mid);
        int rightMax = max(nums, mid + 1, right);
        int crossMax = crossMax(nums, left, right, mid);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
    private int crossMax(int[] nums, int left, int right, int mid) {
        if (left == right) {
            return nums[left];
        }
        int leftPart = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = mid; i >= left; i --) {
            curSum += nums[i];
            leftPart = Math.max(leftPart, curSum);
        }

        int rightPart = Integer.MIN_VALUE;
        curSum = 0;
        for (int i = mid + 1; i <= right; i ++) {
            curSum += nums[i];
            rightPart = Math.max(rightPart, curSum);
        }
        return leftPart + rightPart;
    }
}
```
