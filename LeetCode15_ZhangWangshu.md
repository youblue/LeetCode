# Leetcode 15. 3Sum
@Author: Wangshu Zhang

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
                    /*
                    if(left > i + 1 && nums[left] == nums[left-1]) {
                        left++;
                        continue;
                    }
                    */
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
If remove the commented part, a test case that the code cannot pass is:

Input: [-2,0,0,2,2]

Output: [[-2,0,2],[-2,0,2]]

Expected: [[-2,0,2]]

So the corrected code needs:

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
