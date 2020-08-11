# LeetCode987

* Author：Wangshu Zhang
* Version：2020-08-07

# Problem: Vertical Order Traversal of a Binary Tree

### Code
```Java
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
    public class Node {
        int y;
        int val;
        Node(int y, int val) {
            this.y = y;
            this.val = val;
        }
    }
    Map<Integer, PriorityQueue<Node> > map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        buildMap(root, 0, 0);
        for (Map.Entry<Integer, PriorityQueue<Node> > entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Node> pq = entry.getValue();
            while (!pq.isEmpty()) {
                list.add(pq.poll().val);
            }
            res.add(list);
        }
        return res;
    }


    private void buildMap(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        if (map.containsKey(x)) {
            PriorityQueue<Node> pq = map.get(x);
            pq.add(new Node(y, root.val));
            map.put(x, pq);
        } else {
            PriorityQueue<Node> pq = new PriorityQueue<>(new myComparator());
            pq.add(new Node(y, root.val));
            map.put(x, pq);
        }
        buildMap(root.left, x - 1, y + 1);
        buildMap(root.right, x + 1, y + 1);
    }

    class myComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.y != b.y) {
                return a.y - b.y;
            } else {
                return a.val - b.val;
            }
        }
    }
}
```
