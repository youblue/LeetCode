# LeetCode46
* 作者：张望舒
* 版本：2018-02-28

# 题目描述Permutations

# 思路报告
1. 这道题继续用Ben老师讲过的三个小朋友的故事来做例子，输入nums = [1,2,3]。最有用的方法就是现在纸上画出树型图。

                                       [ ]
                            [1]        [2]         [3]
                          [2] [3]    [1] [3]     [1] [2]
                         [3]   [2]  [3]   [1]   [2]   [1]

然后用老师给的模板做：

```Java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }
    private void helper(int[] nums,  List<List<Integer>> result, List<Integer>path, boolean[] isVisited) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(isVisited[i] == true) {
                continue;
            }
            path.add(nums[i]);
            isVisited[i] = true;
            helper(nums, result, path, isVisited);
            path.remove(path.size()-1);
            isVisited[i] = false;
        }
    }
}
```

但是其实这样写也可以AC（不用isVisited数组）：
```Java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, result, new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] nums,  List<List<Integer>> result, List<Integer> path) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            helper(nums, result, path);
            path.remove(path.size()-1);
        }
    }
}
```
# 套路总结
* 树状图非常有利于理解DFS。
* 收获了Permutaion的模板写法。



# 附：按Ben老师的讲述自己试着按照代码run
### 一个推小朋友的故事。。。


调用helper

座位数（=0） != 小朋友个数（=3）

i = 0: 一号小朋友, 没被visit过，加到path里，mark他被visit过了

path = [1]

{调用helper:

座位数（=1） != 小朋友个数（=3）

i = 0: 一号小朋友被visit过了，continue

i = 1: 二号小朋友没被visit过，加到path里，mark他被visit过了

path = [1,2]

{调用helper:

座位数（=2） != 小朋友个数（=3）

i = 0: 一号小朋友被visit过了，continue

i = 1: 二号小朋友被visit过了，continue

i = 2: 三号小朋友没被visit过，加到path里，mark他被visit过了

path = [1,2,3]

{调用helper:

座位数（=3） == 小朋友个数（=3）

输出path到result里，result = [[1,2,3]]，返回}

把三号小朋友从椅子上拽下来，mark他没被visit过

path = [1,2]

i++后不满足for loop条件，跳出循环}

把二号小朋友从椅子上拽下来，mark他没被visit过

path = [1]

i++之后i = 2: 三号小朋友没被visit过，加到path里，mark他被visit过了

path = [1,3]

{调用helper:

座位数（=2） != 小朋友个数（=3）

i = 0: 一号小朋友被visit过了，continue

i = 1: 二号小朋友没被visit过，加到path里，mark他被visit过了

path = [1,3,2]

{调用helper:

座位数（=3） == 小朋友个数（=3）

输出path到result里，result = [[1,2,3], [1,3,2]]，返回}

把二号小朋友从椅子上拽下来，mark他没被visit过

i++之后i = 2: 三号小朋友被visit过, continue

i++后不满足for loop条件，跳出循环}

把三号小朋友从椅子上拽下来，mark他没被visit过

path = [1]

i++后不满足for loop条件，跳出循环}

把一号小朋友从椅子上拽下来，mark他没有被visit过

path = []

==========================================

i++ = 1

二号小朋友没被visit过，加到path里，mark他被visit过了

path = [2]

{调用helper:

座位数（=1） != 小朋友个数（=3）

i = 0: 一号小朋友没被visit过，加到path里，mark他被visit过了

path = [2,1]

{调用helper:

座位数（=2） != 小朋友个数（=3）

i = 0: 一号小朋友被visit过了，continue

i = 1: 二号小朋友被visit过了，continue

i = 2: 三号小朋友没被visit过，加到path里，mark他被visit过了

path = [2,1,3]

{调用helper:

座位数（=3） == 小朋友个数（=3）

输出path到result里，result = [[1,2,3], [1,3,2], [2,1,3]]，返回}

把三号小朋友从椅子上拽下来，mark他没被visit过

path = [2,1]

i++后不满足for loop条件，跳出循环}		

把一号小朋友从椅子上拽下来，mark他没被visit过

path = [2]

i++之后i = 1: 二号小朋友被visit过了，continue

i++之后i = 2: 三号小朋友没被visit过，加到path里，mark他被visit过了

path = [2, 3]

{调用helper:

座位数（=2） != 小朋友个数（=3）

i = 0: 一号小朋友没被visit过，加到path里，mark他被visit过了

path = [2,3,1]   		 

{调用helper:

座位数（=3） == 小朋友个数（=3）

输出path到result里，result = [[1,2,3], [1,3,2], [2,1,3], [2,3,1]]，返回}

把一号小朋友从椅子上拽下来，mark他没被visit过


====== 未完待续（感觉已昏厥，觉得还是让程序自己想吧， 深深地理解了为什么要用recursion） ======
