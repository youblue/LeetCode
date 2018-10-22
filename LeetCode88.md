# LC 88 Merge Sorted Array

* Author：Wangshu Zhang
* Version：2018-10-22

```Java
// My version, really tedious
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) {
            nums1 = nums2;
        }

        int i = m + n - 1, p1 = m - 1, p2 = n - 1;
        while (i >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[i--] = nums1[p1--];
                } else {
                    nums1[i--] = nums2[p2--];
                }
            } else if (p1 < 0) {
                while (p2 >= 0) {
                    nums1[i--] = nums2[p2--];
                }
            } else {
                break;
            }
        }
    }
}
```
* 能够证明这个方法的正确性吗？假设nums1中的第i个元素会被nums2中的第j个元素覆盖。那么，可以推导出nums1[i]<nums2[j]，并且在这种情况下，我们需要i元素最终的位置要位于i之前。但是在nums1中有i-1个元素小于第i个元素，因此i元素至少在i-1之后。于是矛盾。


```Java
// Other shorter solution
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
          int pos1 = m - 1, pos2 = n - 1, last = m + n - 1;
          while(pos1 >= 0 && pos2 >= 0) {
              nums1[last--] = nums1[pos1] > nums2[pos2] ? nums1[pos1--] : nums2[pos2--];
          }
          while(pos2 >= 0) {
              nums1[last--] = nums2[pos2--];
          }
    }
}
```

```Java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
          int pos1 = m - 1, pos2 = n - 1, last = m + n - 1;
          while(last!=-1) {
                if( pos1==-1 || (pos2!=-1 && nums1[pos1]<nums2[pos2]) ) {
                    nums1[last--] = nums2[pos2--];
                } else {
                    nums1[last--] = nums1[pos1--];
                }  
          }
    }
}
```
