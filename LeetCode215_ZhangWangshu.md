# LeetCode215
* Author：Wangshu Zhang
* Version：2018-03-22

# Problem: Kth Largest Element in an Array

# Thoughts
* By brute force method, we just need to sort the whole array and access the Kth index starting from the end. The time complexity is O(nlogn).
* The tricky part is, we do not need the data to be completely sorted! Every time in iteration, if we can discard parts of the data and concentrating on the remaining part, then we do not need to deal with both of the two parts, then the average time complexity would decrease to O(n)! Because:
    * For a general sorting algorithm, T(n) = 2 \* n/2 + 4 \* n/4 + 8 \* n/8 + ... = O(nlogn).
    * For our method, T(n) = n/2 + n/4 + n/8 + ... = O(n).
* This method is called "QuickSelect", which utilizes the first part of "QuickSort".

### Code
```Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }
    private int quickSelect(int[] nums, int k, int left, int right) {
        int start = left, end = right, pivot = nums[end];
        while(start < end) {
            if (nums[start] < pivot) {
                ++start;
            } else {
                --end;
                swap(nums, start, end);
            }
        }
        swap(nums, end, right);
        int largerCount = right - end + 1;
        if (largerCount == k) {
            return nums[end];
        } else if (largerCount < k) {
            return quickSelect(nums, k - largerCount, left, end - 1);
        } else {
            return quickSelect(nums, k, end + 1, right);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
# Summary
* On an unsorted array, for the problem of finding Kth element qualifying some criteria, we can try QuickSelect.
* The part needs to be paid more attention is the termination condition, and start and end index of the QuickSelect.
* This question is a very good general case for many similar problems: find the median, find the Kth smallest, etc.
