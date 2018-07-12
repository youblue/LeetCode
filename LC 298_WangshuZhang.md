# Leetcode 298. Binary Tree Longest Consecutive Sequence
@Author: Wangshu Zhang

# Thoughts
* This problem can be thought about from bottom-up. For any current node, we compare the length of consecutive sequence from left subtree and that from right subtree, and take a maximum of them then plus 1. If the left or right branch cannot form a consecutive sequence with the current node, we then need to reset the the length as 1.
* Because we need to finally return a global maximum result, here I use a helper function.

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

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = {1};
        longestConsecutive(root, res);
        return res[0];
    }
    private int longestConsecutive(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = longestConsecutive(root.left, res);
        int right = longestConsecutive(root.right, res);

        if (root.left != null && root.left.val != root.val + 1) {
            left = 0;
        }
        if (root.right != null && root.right.val != root.val + 1) {
            right = 0;
        }

        if (res[0] < Math.max(left, right) + 1) {
            res[0] = Math.max(left, right) + 1;
        }
        return Math.max(left, right) + 1;
    }
}
```


# Summary
* The time complexity should be O(N) because we traverse every node on a tree.
