# Leetcode 80. Remove Duplicates from Sorted Array II
@Author: Wangshu Zhang

# Thoughts
* Based on "LC 26: Remove Duplicates from Sorted Array", first I think I need to add a counter to count the number of duplicates. Whenever there's a different number, I reset the counter to 1. Besides the case that there's a different number, if the counter < 2, we also need to overwrite the array.
* But later I think there's a more tricky way to avoid counter: just re-write every elements in array if it is valid (duplicates <= 2), and compare the current value with the 2 position before current one in the valid array.

### Code
```Java
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0, counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                counter = 1;
                nums[j + 1] = nums[i];
                j++;
            } else {
                if (counter < 2) {
                    nums[j + 1] = nums[i];
                    j++;
                }
                counter++;
            }
        }
        return j + 1;
    }
}
```

```Java
// Concise in code, but may need more time
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int x : nums) {
            if (j < 2 || x > nums[j - 2]) {
                nums[j++] = x;
            }
        }
        return j;
    }
}
```

# Summary
* This problem uses fast-slow two pointer method. The fast pointer just brainlessly iterate the array, and the slow pointer mark the place for last valid written output. Time complexity O(n), space complexity O(1).
