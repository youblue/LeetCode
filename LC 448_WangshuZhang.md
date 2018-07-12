# Leetcode 448. Find All Numbers Disappeared in an Array
@Author: Wangshu Zhang

# Thoughts
* This problem requires O(n) time complexity and O(1) space complexity so we cannot build a HashMap to solve. But the trick is, the array itself contains two parts of information: the index and value. So we can use swap to try assigning all values to the correct index (position). The remaining values which cannot be assigned correctly correspond to indices (positions) that are missing.

### Code
```Java
// Based on sorted array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
4 3 2 7 8 2 3 1
7 3 2 4 8 2 3 1
3 3 2 4 8 2 7 1
2 3 3 4 8 2 7 1
3 2 3 4 8 2 7 1

3 2 3 4 1 2 7 8
1 2 3 4 3 2 7 8
*/
```


```Python
class Solution:        
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
        return res
```

# Summary
* This problem uses a method which calls "归位排序". I think it's basically the same as the idea of Hash Map, but avoid using more space complexity of Hash Map.
