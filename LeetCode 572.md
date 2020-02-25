# LeetCode572

* Author：Wangshu Zhang
* Version：2020-02-24

# Problem: Subtree of Another Tree

# Thoughts
* The definition "A subtree of s is a tree consists of a node in s and all of this node's descendants."
* At first I tried to do it in two steps: first search tree s to find the node with the same value as the root of t; then I traverse every subtree in s and tree t at the same time to see if they are exactly the same. However I met errors: I didn't notice that s and t a are not binary search tree, i.e., there might exist nodes with duplicated values. So in the search step actually I have to keep every searching results (otherwise will miss correct subtrees).
* So I try to think it in a more simply way, to fully use recursion. The hint is from one sentence of the question: "The tree s could also be considered as a subtree of itself". So there are only three possibilities that return true: (1) s is the same as t; (2) t is subtree of s.left; and (3) t is subtree of s.right.



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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
```



# Summary
* Use recursion.
* Pay attention to the corner cases.
* Pay attention it's "return isSubtree(s.left, t) || isSubtree(s.right, t);", not "return isSame(s.left, t) || isSame(s.right, t);"!
