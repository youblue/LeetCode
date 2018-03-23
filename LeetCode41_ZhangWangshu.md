# LeetCode41
* 作者：张望舒
* 版本：2018-03-15

# 题目描述First Missing Positive

# 思路报告
*

### 代码

```Java
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] >= nums.length) {
                continue;
            }
            if(nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
# 套路总结
* 这道题最开始想成了快慢指针追击问题，用一个指针无脑循环，另一个指针判断是否处理完毕。但是之后觉得这样做没有必要，而且尝试了作了一下很容易出错。因为数组的下标+1就可以对应该位置应该存的正整数（两者有非常漂亮的一一对应关系），而最终缺哪个正整数再从头扫描一下数组就可以了。
