# Leetcode 81. Search in Rotated Sorted Array II
@Author: Wangshu Zhang

# Thoughts
* This problem we need to consider about multiple cases, and discuss them separately.
    * If the middle point equals the end, then we cannot decide which part we would drop in a binary search, therefore have to reduce the end pointer by 1.
    * Otherwise, if the middle is larger than the end, which means we are in the "first part" of the arrays. Then we check if the middle is smaller than target or not.
    * Or, if the middle is smaller than the end, which means we are in the "second part" of the arrays. Samely we then check if the middle is smaller than target or not.

### Code
```Java
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[end]) {
                if (nums[mid] < target) {
                    start = mid;
                } else {
                    if (nums[start] > target) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            } else if (nums[mid] < nums[end]) {
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    if (nums[end] < target) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
            } else {
                end = end - 1;
            }
        }
        if(nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}
```

# Summary
* I still prefer to write binary search in the way of "start + 1 < end", because I do not need to worry about the possible bugs, and put more efforts into other important part.
