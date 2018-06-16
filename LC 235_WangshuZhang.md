# Leetcode 235. Lowest Common Ancestor of a Binary Search Tree
@Author: Wangshu Zhang

# Thoughts
* When I saw this problem, the first question coming into my mind is: what is the difference between this problem and the problem Leetcode 236? Then I tried copying the solution of LC 236 to this problem, and it is accepted! The time complexity is O(n) (n is the total number of nodes in the tree) since we need to traverse the tree.
* Then I think, can I improve the time complexity to O(log n)? Because here the tree is a binary search tree, which has an additional property that for any node, the left subtree values are smaller than this node's value, and all the right tree values are larger than this node's value, which provide a possibility to do binary search. Therefore, I used binary search instead of traversing every node, and keep the same recursion schema as LC 235 (i.e., through recursion, find p and q, and find the root of their closest common subtree that they lies in).

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

// Solution using code of Leetcode 236
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
```

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
 // Solution of O(logn), can further change the order of if, else if, else to simplify
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val || p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val) {
            return root;
        } else if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
```

# Summary
The code is written in bottum-up way, with the idea of divide and conquer. If thinking of top-down, then I first need to find these two nodes separately, and record all nodes through the paths (probably construct a parent pointer or using stack), but we still need to trace back to find the common parent, which is more complicated.
