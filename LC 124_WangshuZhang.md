# Leetcode 124. Binary Tree Maximum Path Sum
@Author: Wangshu Zhang

# Thoughts
* For this problem we'd better use recursion otherwise there are too many cases from top to down. Because in the maxPathSum main function, we want to return the maximum path (contains "loop"), but during the recursion we need to return a path sum that does not contains loop. Therefore, I write another helper function, and let it do the most recursion calls.
* For a certain root node, we want to calculate two kinds of sums:
    * Max path sum: the maximum of (root.val, root.val + left max path sum, and root.val + right max path sum);
    * Max global sum: the maximum of (current global max sum, Max path sum, and a loop sum by adding left/right/root.val).
* We don't need to return the global max sum in the helper function, because it has been updated automatically.

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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {root.val};
        int res = helper(root, maxSum);
        return maxSum[0];
    }
    private int helper(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, maxSum);
        int right = helper(root.right, maxSum);

        int pathMax = Math.max(root.val, root.val + Math.max(left, right));
        maxSum[0] = Math.max(maxSum[0], Math.max(left + right + root.val, pathMax));
        return pathMax;
    }
}
```

# Summary
* Writing a numeric value into an array and passing this array as a parameter, would avoid defining a global variable.
