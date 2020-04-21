# LeetCode1008

* Author：Wangshu Zhang
* Version：2020-04-20

# Problem: Construct Binary Search Tree from Preorder Traversal

# References:
https://www.cnblogs.com/Dylan-Java-NYC/p/11119359.html
https://www.youtube.com/watch?v=U-x4uIhqBF4

Remember not only can binary search by position, we can also binary search by values!

### Code
```Java
// TLE: NOT WORKING

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l]);
        int rightStart = l + 1;
        while (rightStart <= r && preorder[rightStart] < preorder[l]) {
            rightStart ++;
        }
        root.left = dfs(preorder, l, rightStart - 1);
        root.right = dfs(preorder, rightStart, r);
        return root;
    }
}

```


```Java
// WORKING SOLUTION!
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
    private int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode dfs(int[] preorder, int min, int max) {
        if (i >= preorder.length) {
            return null;
        }
        if (preorder[i] < min || preorder[i] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        i ++;
        root.left = dfs(preorder, min, root.val);
        root.right = dfs(preorder, root.val, max);
        return root;
    }
}
```
