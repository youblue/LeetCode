# Leetcode 102. Binary Tree Level Order Traversal
@Author: Wangshu Zhang

# Thoughts
* A more intuitive way to solve this problem is using BFS, because we are asked to travel and store nodes' values in a "level" order. For BFS approach, we need a Queue to store values of each level.
* Can we write in a DFS way? We can, without defining actural data structure, but need to build a helper function. The most difficult part is how to divide the tree into different levels when implementing DFS. Here I use "height == res.size()", where height is the current level number (root is with height 0), and since "res" is a list of list, so "res.size()" equals height only when the current level has been first reached.

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

// BFS version
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = q.removeFirst();
                level.add(root.val);
                if (root.left != null) {
                    q.addLast(root.left);
                }
                if (root.right != null) {
                    q.addLast(root.right);
                }
            }
            res.add(new ArrayList<>(level));
        }
        return res;
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

// DFS version
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height == res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(root.val);
        helper(res, root.left, height + 1);
        helper(res, root.right, height + 1);
    }
}
```

# Summary
* BFS is more intuitive, but also practice DFS to better understand recursion.
