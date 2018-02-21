# LeetCode98
* 作者：张望舒
* 版本：2018-02-20

# 题目描述Validate Binary Search Tree
* Input: TreeNode root
* Output: boolean

# 思路报告
1. 这道题比较巧妙的做法是判断输入的树按inorder traversal之后是不是一个从小到大sorted的序列，如果是的话那么原树就是binary search tree。这个是利用binary search tree的一个性质。

2. 这里面我用了一个比较中规中矩的做法，就是用divide and conquer的思想：如果这个树是一个valid binary search tree，那么它的left subtree和right subtree必然都是valid binary search tree，并且左子树的最大值 < root < 右子树的最小值。

3. 因为返回值只是boolean而divide and conquer需要recursion，所以我们需要额外建立一个helper函数。另外因为输入TreeNode里面没有包含以当前节点为根的树中最小值、最大值以及是否valid的信息，所以我们需要在函数体外额外定义一个ResultType类。

4. 用divide and conquer的做法：

  (1) 递归的出口：空的树(可以理解为叶子节点的下一层)是满足binary search tree的所以is.valid = true。min设为最大整数，max设为最大整数。
  (2) Divide：分别判断left subtree和right subtree是否valid。
  (3) Conquer:

  * 如果当前节点的左右子树有任何一个不是valid binary search tree则返回false。

  * 如果不为空的左子树的最大值 >= 当前节点值，或不为空的右子树中的最小值 <= 当前节点值，则返回false。

  * 否则将当前节点的min更新为左子树的最小值和当前节点值比较的最小值，将当前节点的max更新为右子树的最大值和当前节点值比较的最大值。


### 代码

```Java
// Java
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
        boolean isValid;
        int min, max;
        ResultType(boolean isValid, int min, int max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }

        ResultType result = helper(root);
        return result.isValid;

    }

    public ResultType helper(TreeNode node) {
        if(node == null) {
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ResultType left = helper(node.left);
        ResultType right = helper(node.right);


        if(left.isValid == false || right.isValid == false) {
            return new ResultType(false, 0, 0);
        }

        if(node.left != null && left.max >= node.val || node.right != null && right.min <= node.val) {
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.min(left.min, node.val), Math.max(right.max, node.val));

    }
}
```


# 套路总结

* 这种做法是从定义出发，不容易出错，但是代码量相对比较大因为要额外定义ResultType。
* 这道题用inorder traversal做比较简单，但是不是很通用。
