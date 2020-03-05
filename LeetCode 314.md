# LeetCode314

* Author：Wangshu Zhang
* Version：2020-02-25

# Problem: Binary Tree Vertical Order Traversal

# Thoughts
I listened to video by this girl, really like her presentation:
https://www.youtube.com/watch?v=QWbVCqIhTO4

![Image description](https://github.com/youblue/LeetCode/blob/master/IMG_LC314.JPG)


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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer> >res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        class Node {
            TreeNode treeNode;
            int coor;
            Node(TreeNode treeNode, int coor) {
                this.treeNode = treeNode;
                this.coor = coor;
            }
        }
        Map<Integer, List<Integer> >map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Node node = q.poll();
            map.putIfAbsent(node.coor, new ArrayList<Integer>());
            map.get(node.coor).add(node.treeNode.val);
            if (node.coor < min) {
                min = node.coor;
            }
            if (node.coor > max) {
                max = node.coor;
            }
            if (node.treeNode.left != null) {
                q.offer(new Node(node.treeNode.left, node.coor - 1));
            }
            if (node.treeNode.right != null) {
                q.offer(new Node(node.treeNode.right, node.coor + 1));
            }
        }
        for (int i = min; i <= max; i ++) {
            List<Integer> list = map.get(i);
            res.add(list);
        }
        return res;
    }
}
```



# Summary
* The key point is to remember to create a inner class Node(Tree Node, int x_coordinate).
