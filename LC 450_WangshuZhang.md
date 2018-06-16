# Leetcode 450. Delete Node in a BST
@Author: Wangshu Zhang

# Thoughts
* Apparently this problem is suitable for recursion, because otherwise there are too many cases to consider from top to down.
* Remember when we delete an element in an array which is in the middle, we do not really delete the whole space that stores the element because it would generate "holes". What we do is borrowed the value of the last element of the array, put that value into the current position, and then delete the last element (or truncate the length of array by 1). Here the thing is similar. We do not actually need to destroy the structure of the tree when deleting a node, what we do is just fill the current node's value with another trivial node who is easier to be deleted.
* So here using the property of BST, if the key is smaller than the current root value, then the to-be-deleted node is in the left subtree, and if the key is larger than the current root value, then the node to be deleted is in the right subtree. In each case, the return value is the root of the modified subtree. Otherwise, the to-be-deleted node is the current root, then we need to check if one side of the current root empty, if so we can directly let the new root be the root of the other side of its child subtree. Or unluckily if neither sides of its subtrees are empty, say, assume we checked the left side, then we would first set the current root value be that of the upmost right node of its left subtree, and then delete the upmost right node in the left subtree.


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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode newRoot = root.left;
                while (newRoot.right != null) {
                    newRoot = newRoot.right;
                }
                root.val = newRoot.val;
                root.left = deleteNode(root.left, newRoot.val);
            }
        }
        return root;
    }
}
```

# Summary
Pay attention to the return value of recursion. This return value also indicates how we divide big problem into small parts.
