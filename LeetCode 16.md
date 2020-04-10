# LeetCode16

* Author：Wangshu Zhang
* Version：2020-04-09

# Problem: 3Sum Closest

### Code
```Java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < nums.length - 2; i ++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left ++;
                } else {
                    right --;
                }
                if (Math.abs(target - sum) < diff) {
                    diff = Math.abs(target - sum);
                    res = sum;
                }
            }
        }
        return res;
    }
}
```
