# LeetCode215

* Author：Wangshu Zhang
* Version：2021-01-16

# Problem: Kth Largest Element in an Array

### Code
```Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Finding a value with index nums.length - k
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }
    private int quickSelect(int[] nums, int k, int start, int end) {
        int i = start + 1, j = end, pivot = nums[start];
        System.out.println(k);
        while (i <= j) {
            if (nums[i] < pivot) {
                i ++;
                continue;
            }
            if (nums[j] > pivot) {
                j --;
                continue;
            }
            swap(nums, i, j);
            i ++;
            j --;
        }
        swap(nums, start, j);
        System.out.println(j);
        if (j == k) {
            return nums[j];
        } else if (j > k) {
            return quickSelect(nums, k, start, j - 1);
        } else {
            return quickSelect(nums, k, j + 1, end);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
