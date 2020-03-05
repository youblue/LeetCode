# LeetCode98

* Author：Wangshu Zhang
* Version：2020-03-05

# Problem: Validate Binary Search Tree

# Thoughts
I know for this problem we have to use recursion. But the key points are:

(1) We need an extra class type because we need to store the min and max value of each subtree.

(2) How to design the helper function (what parameters, what to return).

I need to re-visit this problem again and again, because it is hard to bug-free once.

### Code
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
    class Subtree {
        boolean isBST;
        int min;
        int max;
        Subtree(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        Subtree subtree = helper(root);
        return subtree.isBST;
    }
    public Subtree helper(TreeNode root) {
        if (root == null) {
            return new Subtree(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Subtree left = helper(root.left);
        Subtree right = helper(root.right);
        if (left.isBST == false || right.isBST == false) {
            return new Subtree(false, 0, 0);
        }
        if ((root.left != null && left.max >= root.val)
            || (root.right != null && right.min <= root.val)) {
            return new Subtree(false, 0, 0);
        }
        return new Subtree(true, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }
}
```



# Summary
* The definition of BST:
  * The left subtree of a node contains only nodes with keys less than the node's key.
  * The right subtree of a node contains only nodes with keys greater than the node's key.
  * Both the left and right subtrees must also be binary search trees.
