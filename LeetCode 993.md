# LeetCode993

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-08

# Problem: Cousins in Binary Tree

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

    int[] depthX = new int[1];
    int[] depthY = new int[1];
    boolean sameParent = false;
    public boolean isCousins(TreeNode root, int x, int y) {

        isCousinsHelper(root, x, y, depthX, depthY, 1);
        if (depthX[0] == 0 || depthY[0] == 0 || sameParent) {
            return false;
        } else if (depthX[0] == depthY[0]) {
            return true;
        } else {
            return false;
        }
    }

    public void isCousinsHelper(TreeNode root, int x, int y, int[] depthX, int[] depthY, int currDepth) {
        currDepth++;
        if (root.left == null && root.right == null) {
            return;
        } else if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y){
                sameParent = true;
                return;
            } else if (root.left.val == y && root.right.val == x) {
                sameParent = true;
                return;
            } else if (root.left.val == x || root.right.val == x) {
                depthX[0] = currDepth;
            } else if (root.left.val == y || root.right.val == y) {
                depthY[0] = currDepth;
            }
            isCousinsHelper(root.left, x, y, depthX, depthY, currDepth);
            isCousinsHelper(root.right, x, y, depthX, depthY, currDepth);
        } else if (root.left == null) {
            if (root.right.val == x) {
                depthX[0] = currDepth;
            } else if (root.right.val == y) {
                depthY[0] = currDepth;
            }
            isCousinsHelper(root.right, x, y, depthX, depthY, currDepth);
        } else {
            if (root.left.val == x) {
                depthX[0] = currDepth;
            } else if (root.left.val == y) {
                depthY[0] = currDepth;
            }  
            isCousinsHelper(root.left, x, y, depthX, depthY, currDepth);
        }
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
    class ResultType {
        int height;
        TreeNode parent;
        ResultType(int height, TreeNode parent) {
            this.height = height;
            this.parent = parent;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        ResultType resultX = helper(root, x, 0, null);
        ResultType resultY = helper(root, y, 0, null);
        return resultX.height == resultY.height && resultX.parent != resultY.parent;
    }
    ResultType helper(TreeNode root, int x, int height, TreeNode parent) {
        if (root.val == x) {
            return new ResultType(height, parent);
        }
        ResultType left = null, right = null;
        if (root.left != null) {
            left = helper(root.left, x, height + 1, root);
        }
        if (root.right != null) {
            right = helper(root.right, x, height + 1, root);
        }
        return left != null ? left : right;
    }
}
```
