# LeetCode442

* Author：Wangshu Zhang
* Version：2020-08-06

# Problem: Find All Duplicates in an Array

### Code
```Java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            } else {
                res.add(Math.abs(nums[i]));
            }
        }
        return res;
    }
}
```
