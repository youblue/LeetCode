# LeetCode285
* 作者：张望舒
* 版本：2018-02-21

# 题目描述Inorder Successor in BST


# 思路报告
1. 找inorder successor，利用binary search tree的性质只需要不断比较当前节点值root.val和p.val，只有两种可能的情况：

   (1) p.val >= root.val：inorder successor一定在以root.right为根的subtree中；

   (2) p.val < root.val：inorder successor可能在root.left中，如果不在那就是root自己。

2. 如果p.val的值能一直大于root.val，那自然就会一直在右子树寻找，最后右子树为空的话那就返回null，就代表没有inorder successor的存在。

### 代码

```Java
// 递归解法
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return root;
        }
        if(p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode result = inorderSuccessor(root.left, p);
            if(result == null) {
                return root;
            } else {
                return result;
            }
        }
    }
}
```

```Java
// 非递归解法
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return root;
        }
        TreeNode pre = null;
        while(root != null) {
            if(p.val >= root.val) {
                root = root.right;
            } else {
                pre = root;
                root = root.left;
            }
        }
        return pre;
    }
}
```


# 套路总结

* 实际写递归的时候才发现这道题是一道尾递归题，所以相对比较好写，而且迭代的思路基本上和递归一样（基本上就是把递归的函数展开）。
* 几个test cases很有用：

  * tree = [2, 1, 3, null, 1.5, null, null, null, 1.75], p.val = 1
  * tree = [2, 3], p.val = 2
  * tree = [2, null, 3, 2.5], p.val = 1000
