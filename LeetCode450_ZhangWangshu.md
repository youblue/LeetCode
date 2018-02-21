# LeetCode450
* 作者：张望舒
* 版本：2018-02-20

# 题目描述Delete Node in a BST
* Input: TreeNode root, int key
* Output: TreeNode


# 思路报告
1. 这道题其实用递归和迭代来做思路都是一样的。就是确定先找到删除的点，再分析删除点时会发生的几种情况。
2. 首先找到需要删除的点，那就需要利用binary search tree的性质：如果key < root.val那就在left subtree找；如果key > root.val那就在right subtree找；如果key == root.val，那就找到了需要删除的点。
3. 如果找到了需要删除的点，那就需要考虑几种情况：

(1) 如果left child == null，那么不管右子树是否为空，都将right child直接作为newRoot即可。

(2) 如果left child != null，那么我们需要找到left subtree中最大的一个node来作为newRoot，这样才能维持binary search tree的性质（左边的点都小于根小于右边的点）。所以就用一个while loop来找，找到了之后为了避免换指针的麻烦，我们交换value。然后把清除包含原来newRoot值的节点交给新的递归函数来实现。

### 代码

```Java
// Java
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
        if(root == null) {
            return root;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // should delete root
            if(root.left == null) {
                root = root.right;
            } else { //
                TreeNode newRoot = root.left;
                while(newRoot.right != null) {
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


# 套路总结

* 要大胆使用递归，因为迭代的时候需要考虑所有情况的whole picture容易有遗漏，而递归只要固定当前的一个“片断”（例如一组当前node和它的left和right childs）来考虑递推关系，会考虑得更全面。

* 在binary search tree上交换节点要尽量交换值，避免交换指针。
