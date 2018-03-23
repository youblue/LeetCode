# LeetCode4
* Author：Wangshu Zhang
* Version：2018-03-22

# Problem: Median of Two Sorted Arrays

# Thoughts
* At first glance I thought of this problem just the merging step of the merge sort, and the median can be met during the merging process. But later I see the time requirement for this problem is O(log (m+n)). Apparently using the double pointer scanning method can only achieve O(m+n).
* So we still need to resort to some "Binary Search" algorithm, in each time, try to "half-size" the problem in O(1) time.
* Here we generalize the problem to finding the Kth smallest number in the two arrays. The idea is very smart: First we let the two arrays each "contribute" their own K/2 smallest numbers. If the sizes of both of the arrays are  larger than k/2, that means for sure we can find the total smallest k/2 number by comparing nums1[beg1+k/2-1] and nums2[beg2+k/2-1]. If an array's size is smaller than k/2, then for this shorter array we cannot decide which part to discard so we just keep it all, but for the other longer array we can for sure to remove k/2.
* There are still some other corner cases to consider. If there's only one array left, then we can just return the kth element from the beginning. Also if k == 1, we do not need to calculate k/2 since it would turn out to be zero, and we just return a maximum.

### Code

```Java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, total / 2) + findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
        }
    }
    private double findKth(int[] nums1, int beg1, int[] nums2, int beg2, int k) {
        if(beg1 >= nums1.length) {
            return nums2[beg2 + k - 1];
        }
        if(beg2 >= nums2.length) {
            return nums1[beg1 + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[beg1], nums2[beg2]);
        }
        int pivot1 = beg1 + k/2 - 1 < nums1.length ? nums1[beg1 + k/2 - 1] : Integer.MAX_VALUE;
        int pivot2 = beg2 + k/2 - 1 < nums2.length ? nums2[beg2 + k/2 - 1] : Integer.MAX_VALUE;
        if(pivot1 < pivot2) {
            return findKth(nums1, beg1 + k / 2, nums2, beg2, k - k / 2);
        } else {
            return findKth(nums1, beg1, nums2, beg2 + k / 2, k - k / 2);
        }
    }
}
```
# Summary
* This code can serve as a template for find Kth element from two sorted array in O(log n) time.
