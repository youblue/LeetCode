# LeetCode145
* 作者：张望舒
* 版本：2018-02-20

# 题目描述Binary Tree Postorder Traversal


# 思路报告
1. 首先完成coding比较简单的递归解法。那么从toot节点来看完成的事情就是：

  (1) 将left subtree后序遍历后的结果加到result里；

  (2) 将right subtree后序遍历后的结果加到result里；

  (3) 将root.val加到result里。

  注意(1)和(2)要用到ArrayList的addAll()方法，而(3)用add()方法就可以了。

2. 非递归的写法。因为知道preorder traversal是在遍历到当前节点时候，先将root.val从尾部加到result里，然后将right node和left node依次存到Stack里面。这样当Stack不为空的时候，不停弹出栈顶元素。所以想到能不能利用preorder traversal已有的code来完成这道题。在遍历到每一组root/left/right的时候，也可以先将root.val加到result里，但是注意用到一个trick是add(0, root.val)，这样就是从result头部加入，这样相对于left和right来说就实现了将root加到result靠后面。然后因为是从result头加入，所以需要依次将right node和left node压入栈中。这样结果就是正确的后序。

### 代码

```Java
// 递归
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;
    }
}
```

```Java
// 非递归
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Deque<TreeNode>stk = new ArrayDeque<>();
        stk.addFirst(root);
        while(!stk.isEmpty()) {
            root = stk.removeFirst();
            result.add(0, root.val);
            if(root.left != null) {
                stk.addFirst(root.left);
            }
            if(root.right != null) {
                stk.addFirst(root.right);
            }
        }
        return result;
    }
}
```


# 套路总结

* 树的前中后序遍历掌握recursion的写法很重要，也需要练习，否则不容易一次写对。

* 有时间还应该多尝试其他alternative的非递归解法。
