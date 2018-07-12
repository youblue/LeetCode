# Leetcode 259. 3Sum Smaller
@Author: Wangshu Zhang

# Thoughts
* This problem assembles the 3Sum but tiny different. Because when we find a solution of 3Sum < target, the feasible directions to move two pointers are not unique. So we must pay attention not to omit any scenarios.
* So when i is fixed, we define two pointers left and right.
    * If the 3Sum is larger than the target, then just simply move the right pointer left.
    * If the 3Sum is smaller than the target, then we first fix the left pointer, add the total spaces between left and right pointers to the result. After that, fix the right pointer and move the left pointer right.


### Code
```Java
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
```

# Summary
* When using two pointers, we must pay attention the logic so that every time we only move one pointer. Avoid the omission of solutions.
