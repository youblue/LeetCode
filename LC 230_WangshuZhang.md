# Leetcode 230. Kth Smallest Element in a BST
@Author: Wangshu Zhang

# Thoughts
* It's easy to think about inorder traversal to find the Kth element, and the time complexity would be O(n).
* But the follow-up question asks "What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?". So a possible optimization is that we reduce the time complexity to O(log n). The only way to realize this is to utilize the property of BST.
* We think about Divide and conquer method, which can used to count all the number of child nodes. Later based on the nubmer of child nodes, we can decide which part of subtree (left or right) can be discarded.

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
// Inorder traversal method: Time complexity O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        while (root != null || !dq.isEmpty()) {
            while (root != null) {
                dq.addLast(root);
                root = root.left;
            }
            root = dq.removeLast();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
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
// Divide and conquer method: Time complexity O(log n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = countNodes(root.left);
        if (left == k - 1) {
            return root.val;
        } else if (left < k - 1) {
            return kthSmallest(root.right, k - 1 - left);
        } else {
            return kthSmallest(root.left, k);
        }
    }
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
```

# Summary
* Be familiar with BST and how to utilize it to binary search and really reduce the time complexity to O(log n).
* Reference:
https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python):-Binary-Search-in-order-iterative-and-recursive
