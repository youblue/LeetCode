# Leetcode 52. N-Queens II
@Author: Wangshu Zhang

# Thoughts
* This problem is easier than "LC 51: N-Queens" because it only needs to output the total count of solutions. A basic idea is using backtracking, using DFS to traverse all possibilities, and then record the number of solutions.
* A tricky part is how to denote the position of "Q", here we use a integer array col, with each element representing the position of Queen in relative rows. Therefore we avoid using a two-dimensional array (which is too redundant) and actually there's only a few possibilities.

### Code
```Java
class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        int[] col = new int[n];
        helper(n, 0, col, res);
        return res[0];
    }
    private void helper(int n, int row, int[] col, int[] res) {
        if (row == n) {
            res[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            col[row] = i;
            if (isValid(row, col)) {
                helper(n, row + 1, col, res);
            }
        }
    }
    private boolean isValid(int row, int[] col) {
        for (int i = 0; i < row; i++) {
            if (col[row] == col[i] || Math.abs(col[row]-col[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
```

# Summary
* The time complexity of backtracking is O(N!), where N is the width/length of the board.
