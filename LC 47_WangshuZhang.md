# Leetcode 47. Permutations II
@Author: Wangshu Zhang

# Thoughts
* This problem is very similar to LC 46 Permutation I, and the only part that needs to pay attention is how to avoid duplicating permutation. So that we need to implement the so-called "Pruing" in the code. Here we need to introduce the isVisited array (in LC46, we can use path.contains(nums[i]) to judge if a number has been visited before but here it won't work because of duplicates).

### Code
```Java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        Arrays.fill(isVisited, false);
        helper(nums, new ArrayList<Integer>(), res, isVisited);
        return res;
    }
    private void helper(int[] nums, ArrayList<Integer> path, List<List<Integer>> res, boolean[] isVisited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] == true) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && isVisited[i-1] == true) {
                continue;
            }
            path.add(nums[i]);
            isVisited[i] = true;
            helper(nums, path, res, isVisited);
            path.remove(path.size() - 1);
            isVisited[i] = false;
        }
    }
}
```

# Summary
* In the pruning process, a magic thing is both the follow two code pieces can get AC:

```Java
if (i > 0 && nums[i] == nums[i-1] && isVisited[i-1] == true) {
    continue;
}
```

and

```Java
if (i > 0 && nums[i] == nums[i-1] && isVisited[i-1] == false) {
    continue;
}
```

Because the first code select the first number of repeated part (skip all the following) and the second code select the last number of repeated part (skip all previous).
