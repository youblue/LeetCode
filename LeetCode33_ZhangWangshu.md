# LeetCode33
* 作者：张望舒
* 版本：2018-02-22

# 题目描述Search in Rotated Sorted Array


# 思路报告
1. 比起边判断转折点和首尾节点的关系边做binary search，我决定采用另一种不容易出错的方式：就是先用二分法找到转折点（注意也有可能不存在，那就是数组第一个元素），然后再对转折点分割的部分分别做binary search。
2. 首先写出binary search的模板，通过if语句来判断我们是找smallest number（转折点）还是找target。这段代码可以作为子函数重用。

  * 找smallest number注意一定要和数组最后一个值比！因为数组可能没有转折点，那么和数组第一个元素比有可能有等于的情况。

3. 找到smallest number之后需要判断一下是否是第一个元素。如果不是第一个元素，那么把数组分成两部分分别binary search；否则把整个数组binary search就可以了。

### 代码

```Java
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int smallest = binarySearch(nums, 0, nums.length-1, nums[nums.length-1], "first_smallerthan_lastElem");
        if(smallest != 0) {
            int left = binarySearch(nums, 0, smallest-1, target, "");
            int right = binarySearch(nums, smallest, nums.length-1, target, "");
             return Math.max(left, right);
        } else {
            return binarySearch(nums, 0, nums.length-1, target, "");
        }    
    }

    public int binarySearch(int[] A, int start, int end, int target, String condition) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(condition == "first_smallerthan_lastElem") {
                if(A[mid] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if(A[mid] == target) {
                    return mid;
                } else if(A[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if(condition == "first_smallerthan_lastElem") {
            if(A[start] < A[end]) {
                return start;
            } else {
                return end;
            }
        } else {
            if(A[start] == target) {
                return start;
            } else if(A[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
    }
}
```


# 套路总结

* 这道题要注意boundary case，就是当数组的转折点不存在的情况，这时候最小值是第一个元素。
* 把可以重用的代码写到函数里。
