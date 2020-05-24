# LeetCode1008

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-23

# Problem: Construct Binary Search Tree from Preorder Traversal

### Code
```Java
// Yili
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        TreeNode curr = root;
        int i = 1;
        while (i < preorder.length) {
            while (i < preorder.length && preorder[i] < curr.val){
                curr.left = new TreeNode(preorder[i]);
                curr = curr.left;
                stack.push(curr);
                i++;
            }

            if (i < preorder.length) {
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    curr = stack.pop();
                }
                curr.right = new TreeNode(preorder[i]);
                curr = curr.right;
                stack.push(curr);
                i++;
            }
        }
        return root;
    }
}
```

```Java
// Wangshu
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode buildTree(int[] preorder, int min, int max) {
        if (i >= preorder.length) {
            return null;
        }
        if (preorder[i] < min || preorder[i] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        i ++;
        root.left = buildTree(preorder, min, root.val);
        root.right = buildTree(preorder, root.val, max);
        return root;
    }
}
```
