# LeetCode124
* 作者：张望舒
* 版本：2018-02-25

# 题目描述Binary Tree Maximum Path Sum

# 思路报告

1. 这道题基本不可能使用top-down的方法，因为要考虑的情况太多了，而且每一个节点都需要它的left和child subtree返回结果才能决定当前那天路径和是最大的。所以这道题特别适合用bottom-up的方法。

2. 这道题感觉可以借鉴Validate Binary Search Tree (LeetCode 98)的做法。
  * Validate Binary Search Tree那道题我是用了divide and conquer的方法来做的：如果left subtree是valid，right subtree是valid，然后再综合当前的节点值把所有结果返回上一层。
  * Binary Tree Maximum Path Sum这道题就是如果left subtree和right subtree的maximum path sum（可能越过root）和maximum single path（不经过root的）都分别知道，那么综合当前节点的值也可以返回结果给上一层。

3. 所以仿造Validate Binary Search Tree那道题的做法，我也建立了一个ResultType class来存储maxPath和(single) path的信息。所以这道题最重要的就是写好递归的出口部分，以及处理好一些corner cases（比如只有一个节点并且值是负数的话是否允许不将这个节点加进去，这里是不允许的）。

4. 递归的出口: 如何初始化叶子节点的path和maxPath：
  * path = 0
  * maxPath = Integer.MIN_VALUE

5. Conquer部分的逻辑是：
  * path是max(leftPath, rightPath) + root.val，如果<0，则存0。
  * maxPath是left.maxPath, rught.maxPath，和left.path + right.path + root.val的最大值。注意不是left.maxPath + right.maxPath + root.val !!!


### 代码

```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class ResultType {
        int path;
        int maxPath;
        ResultType(int path, int maxPath) {
            this.path = path;
            this.maxPath = maxPath;
        }
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }

    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, Integer.MIN_VALUE); // path, maxPath
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer

        int path = Math.max(Math.max(left.path, right.path) + root.val, 0);
        int maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.path + right.path + root.val);

        return new ResultType(path, maxPath);
    }  
}
```


# 套路总结

* 这道题用ResultType这种方法来写总感觉特别不creative，而且新建一个类有了额外的开销程序运行速度也会变慢。

* 其实如果我们把maxPath写成一个全局变量，那么helper函数的返回值是path就可以了，写法如下。但是要注意只有一个节点并且值为负的时候也要加入path中，否则会报错。

```Java
class Solution {
    public int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        int current = Math.max(Math.max(left, right) + root.val, root.val);
        maxPath = Math.max(maxPath, Math.max(current, left+right+root.val));

        return current;
    }
}
```

* 但是在工业界中要避免使用global variable（容易被别人修改），所以老师介绍了一种把max写入helper参数，但是通过传数组reference的办法达到实际上传“地址”的目的。这个是在以后的代码中可以学习这样写。
