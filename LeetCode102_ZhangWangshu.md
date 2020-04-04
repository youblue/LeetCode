# LeetCode102
* 作者：张望舒
* 版本：2018-02-21

# 题目描述Binary Tree Level Order Traversal


# 思路报告
1. 之前做过的Pre-order/In-order/Post-order traversal有一点类似DFS（即可以在Tree的不同层之间traverse）。而这道Level Order Traversal是完全的BFS。一个规律是DFS相关的用Stack，BFS相关的用Queue。

  * Queue can be generally thought as horizontal in structure i.e, breadth/width can be attributed to it - BFS, whereas Stack is visualized as a vertical structure and hence has depth - DFS （从https://stackoverflow.com/questions/3929079/how-can-i-remember-which-data-structures-are-used-by-dfs-and-bfs 上看到的一个比较合理的相关解释）。

2. 建立一个Queue，从root节点那一层起，循环输出每一个Queue中的元素并同时把该元素的左右child加入到Queue中。

### 代码

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelResult.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(levelResult);
        }
        return result;
    }
}
```

```Java
// 递归解法！
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


# 套路总结

* 这道题比较基础，写的时候要做到注意快速写出template并且bug free。
* 有个比较容易写错的地方：

  * 固定int size = q.size()，否则Queue的size会随着poll出元素而减少。
