# LeetCode199
* 作者：张望舒
* 版本：2018-03-01

# 题目描述Binary Tree Right Side View

# 思路报告
1. 这道题是要求输出树的每一层最右侧的一个节点的值，因为涉及到每一层，所以想到了应该用Binary Tree Level Order Traversal。
2. Binary Tree Level Order Traveral是按层输入所有节点，这道题简化了，只需要输出每一层最后一个点就可以了。

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == size - 1) {
                    result.add(node.val);
                }
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return result;
    }
}
```

# 套路总结
* 观察test case找到树的遍历规律，然后套用相应的模板。
