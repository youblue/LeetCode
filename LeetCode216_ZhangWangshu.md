# LeetCode216
* 作者：张望舒
* 版本：2018-03-06

# 题目描述Combination Sum III

```Java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k <= 0 || n < k) {
            return result;
        }
        helper(k, n, 1, new ArrayList<Integer>(), result);
        return result;
    }
    private void helper(int k, int n, int start, ArrayList<Integer> path, List<List<Integer>> result) {
        if(n < 0) {
            return;
        }
        if(n == 0 && path.size() == k) {
            result.add(new ArrayList<Integer>(path));
        }
        for(int i = start; i <= 9; i++) {
            if(path.size() == k) {
                break;
            }
            path.add(i);
            helper(k, n - i, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
```
