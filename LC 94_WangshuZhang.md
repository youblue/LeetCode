# Leetcode 94. Binary Tree Inorder Traversal
@Author: Wangshu Zhang

# Thoughts
* This is a basic algorithm problem of BST. I wrote two versions here: the recursion version and the iterative version.
* In the recursion version, according to definition, we first do inorderTraversal in the left subtree, then the root, and then the right subtree. Pay attention to the Java grammar of using "addAll" instead of using "add" to add a list of values into arraylist.
* In the iterative version, we use a stack to keep track of all the left nodes along the left subtrees, because every time we can add root.val into the stack only if its left has been added before, and finally we add the value of root.right.


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

// Recursion version
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
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

// Non-recursion version
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.addLast(root);
                root = root.left;
            }
            root = stk.removeLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
```

# Summary
Pay attention to details and must be bug free.
