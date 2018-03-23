# LeetCode377
* 作者：张望舒
* 版本：2018-03-06

# 题目描述Combination Sum IV


# 思路报告
1. 这道题我是按照老师上课讲的思路来写。首先观察题目中的例子，nums = [1, 2, 3]， target = 4，如果按照求出不重复子集的方法来做，那么结果应该是：
  (1, 1, 1, 1),
  (1, 1, 2),
  (1, 3),
  (2, 2),
只有4种可能。但是如果对每一个子集再允许重复，那么可以用排列组合公式算出(1, 1, 1, 1)只能有一种，(1, 1, 2)有(3 choose 2)* (1 choose 1) = 3种，(1, 3)有2种，(2, 2)有一种，所以1+3+2+1= 7种。

2. 所以我的思路是首先求出不重复的子集存在result里（参照combinationSum问题的模板可以很容易做到）。然后对存在每一个result里的子集，用排列组合公式算重复子集个数。最后再讲每个子集的可重复个数相加，就是最终结果。

### 代码

```Java
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, target, new ArrayList<Integer>(), result);

        int num = 0;
        for(List<Integer> path : result) {
            num += countPathNum(path);
        }
        return num;
    }
    private void helper(int[] nums, int start, int target, ArrayList<Integer> path, List<List<Integer>> result) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i, target - nums[i], path, result);
            path.remove(path.size() - 1);
        }
    }
    private int countPathNum(List<Integer> path) {
        Map<Integer, Integer> num_count = new HashMap<>();
        for(int key:path) {
            if(!num_count.containsKey(key)) {
                num_count.put(key, 1);
            } else {
                num_count.put(key, num_count.get(key)+1);
            }
        }
        int num = 1;
        int n = path.size();
        for(Map.Entry<Integer, Integer> entry : num_count.entrySet()) {
            num *= choose(n, entry.getValue());
            n -= entry.getValue();
        }
        return num;
    }

    public int choose(int n, int m){
        int cnm = 1;
        for (int i = n-m+1, j = 1; i <= n; i++, j++) {
            cnm*= i;
            cnm/= j;
        }
        return cnm;
    }
}
```


# 套路总结

* 这种方法的代码很长，需要分解成几个函数。为了确保每一步正确，我在调试的时候一直使用System.out.println()来输出结果。
* 尽管这样，如果数据量大这种方法非常容易超时，需要进一步优化。
