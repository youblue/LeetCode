# LeetCode90
* 作者：张望舒
* 版本：2018-03-06

# 题目描述Subsets II

```Java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(path));
        for(int i = start; i < nums.length; i++) {
            if(i != start && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            helper(nums, i + 1, path, result);
            path.remove(path.size()-1);
        }
    }
}
```
