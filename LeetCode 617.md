# LeetCode617

* Author：Wangshu Zhang
* Version：2020-04-08

# Problem: Merge Two Binary Trees

### Code
```Java
// (1) Recursive
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
```

```Java
// (2) Iterative (Using either queue or stack, which are the same!)
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        //Stack<TreeNode[]> stack = new stack<>();
        //stack.push(new TreeNode[] {t1, t2});
        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[]{t1, t2});
        //while (!stack.isEmpty()) {
        while (!q.isEmpty()) {
            //TreeNode[] t = stack.pop();
            TreeNode[] t = q.poll();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                //stack.push(new TreeNode[]{t[0].left, t[1].left});
                q.offer(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                //stack.push(new TreeNode[]{t[0].right, t[1].right});
                q.offer(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
```
