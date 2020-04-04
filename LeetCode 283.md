# LeetCode283

* Author：Wangshu Zhang
* Version：2020-04-04

# Problem: Move Zeroes

### Code
```Java
// Java Version
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                swap(nums, left, i);
                left ++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
