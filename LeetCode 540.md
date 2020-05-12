# LeetCode540

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-11

# Problem: Single Element in a Sorted Array

### Code
```Java
// Yili

```

```Java
// Wangshu
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if ((mid - start) % 2 == 0) {
                if (nums[mid] == nums[mid-1]) {
                    end = mid - 2;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return nums[start];
    }
}
```
