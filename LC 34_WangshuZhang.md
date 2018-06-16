# Leetcode 34. Search for a Range
@Author: Wangshu Zhang

# Thoughts
* The easiest way to do it is use binary search template twice, once for searching the start of the range, and once for searching the end of the range. I used a boolean "flag" parameter to control which code piece should be implemented. The shortage of this solution is that code is very long and does not look elegant.
* Then we think about using the same helper functions to accomplish finding start and end position by re-defining the problem. Because all elements are integers, so we can define:
    * The start point is: the last element < target
    * the end point is: the last element < target + 1
* Here is one optimization: if the end point is not found, which means all elements in the array are larger than the target, then we can directly return {-1, -1}. Otherwise, we can continue finding the start point. So finally we check if start == end, is so it means "not found" as well, otherwise we need to return {start + 1, end} according to our definition.

### Code

```Java
// Original version: Binary search code written twice
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, 0, nums.length - 1, true);
        if (left == -1) {
            return new int[] {-1, -1};
        } else {
            int right = binarySearch(nums, target, 0, nums.length - 1, false);
            return new int[] {left, right};
        }
    }
    private int binarySearch(int[] nums, int target, int start, int end, boolean leftFlag) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (leftFlag) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        } else {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[end] == target) {
                return end;
            } else if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
    }
}
```

```Java
// Simplified version
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int right = findLastSmaller(nums, target + 1);
        if (right == -1) {
            return new int[]{-1, -1};
        }
        int left = findLastSmaller(nums, target);
        if (left == right) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left + 1, right};
        }
    }
    private int findLastSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] < target) {
            return end;
        } else if (nums[start] < target) {
            return start;
        } else {
            return -1;
        }
    }
}
```

# Summary
Given the binary search template, for problem with tiny different search conditions, we can make a transform of the problem and share the same code pieces.
