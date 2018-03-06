# LeetCode39
* 作者：张望舒
* 版本：2018-03-06

# 题目描述Combination Sum

```Java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> result) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, target-candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}
```
