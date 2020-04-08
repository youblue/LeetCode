# LeetCode545

* Author：Wangshu Zhang
* Version：2020-04-08

# Problem: Boundary of Binary Tree

### Code
```Java
// https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_545.java
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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        leftBoundary(root.left, res);
        addLeaves(root.left, res);
        addLeaves(root.right, res);
        rightBoundary(root.right, res);
        return res;
    }

    private void leftBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.left == null) {
            leftBoundary(root.right, res);
        } else {
            leftBoundary(root.left, res);
        }
    }

    private void rightBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right == null) {
            rightBoundary(root.left, res);
        } else {
            rightBoundary(root.right, res);
        }
        res.add(root.val);
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }
}
```
