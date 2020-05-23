# LeetCode230

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-19

# Problem: Kth Smallest Element in a BST

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
    public int kthSmallest(TreeNode root, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        addNode(deque, root);
        while (k > 1) {
            deque.removeLast();
            k--;
        }
        return deque.removeLast();
    }

    public void addNode(Deque<Integer> deque, TreeNode root) {
        if (root != null) {
            addNode(deque, root.left);
            deque.addFirst(root.val);
            addNode(deque, root.right);
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
    public int kthSmallest(TreeNode root, int k) {
        int left = countNodes(root.left);
        if (left == k - 1) {
            return root.val;
        } else if (left < k - 1) {
            return kthSmallest(root.right, k - left - 1);
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

```Java
// Wangshu: Inorder traversal
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            i ++;
            if (i == k) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
```
