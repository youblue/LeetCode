# LeetCode47
* 作者：张望舒
* 版本：2018-03-01

# 题目描述Permutations II

# 思路报告
1. 这道题继续用Ben老师讲过的三个小朋友的故事来做例子，输入nums = [1,2,3]。最有用的方法就是现在纸上画出树型图。

                                     [ ]
                            [1]      [1]      [2]
                          [1] [2]           [1] [1]
                         [2]   [1]         [1]

然后就发现了规律：每一层如果横向出现前面出现过的数字，那么那个重复的数字就不再需要有子树了。

2. 那怎么看出来一个点是重复点呢？

  (1) 首先数组应该先sort一下，这样就可以用nums[i] == nums[i-1]来判断是否重复了。

  (2) 横向的点应该是这一轮向path添加元素的过程中还没有被visited的点。所以在Permutations那道题的模板上多加一个限定条件：isVisited[i-1] == false


```Java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        helper(result, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, List<Integer> path, boolean[] isVisited) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(isVisited[i] == true) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && isVisited[i-1] == false) {
                continue;
            }
            path.add(nums[i]);
            isVisited[i] = true;
            helper(result, nums, path, isVisited);
            path.remove(path.size()-1);
            isVisited[i] = false;
        }
    }
}
```
# 套路总结

* 树状图非常有利于理解DFS。
* 收获了Permutaion的模板写法。
