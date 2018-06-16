# Leetcode 15. 3Sum
@Author: Wangshu Zhang

# Thoughts
* The structure of this problem is very similar to LeetCode problem 15, but have tiny difference. The most difficult part is to remove duplicates.
* Since we are summing over three numbers, so there are two parts in codes that can produce duplicates, which are, the first number nums[i], and the second number nums[left]. If we can avoid duplicates in these two numbers, then the third number would not be duplicated to meet a sum of 0, and therefore the result would be unique.

### Code

```Java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while(left < right) {        
                if(nums[i] + nums[left] + nums[right] == 0) {
                    if(left > i + 1 && nums[left] == nums[left-1]) {
                        left++;
                        continue;
                    }
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(nums[i] + nums[left] + nums[right] < 0) {
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
In this problem, one needs to always keep in mind removing the duplicates. And also don't forget there are two parts in codes that need this duplicate check.
