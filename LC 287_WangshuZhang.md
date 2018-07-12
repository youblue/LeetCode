# Leetcode 287. Find the Duplicate Number
@Author: Wangshu Zhang

# Thoughts
* This problem one typical solution is using binary search of values.
* We use a counter to check if the array's distribution is "left skew" in value or "right skew" in value, based on which we can select the half that the duplicates lie in.

### Code
```Java
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 1, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int counter = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    counter++;
                }
            }
            if (counter > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
```



# Summary
* The time complexity can be O(n log n). Space complexity O(1).
