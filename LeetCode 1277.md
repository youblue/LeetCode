# LeetCode1277

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-20

# Problem: Count Square Submatrices with All Ones

### Code
```Java
// Yili
class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] totalS = {0};
        countR(matrix, row, col, totalS, 1);
        return totalS[0];
    }

    public void countR(int[][] matrix, int row, int col, int[] totalS, int target) {
        if (row > 0 && col > 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == target) {
                        totalS[0]++;
                    }
                    if ((i != row - 1) && (j != col - 1)) {
                        matrix[i][j] = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];                   
                    }
                }
            }
            row--;
            col--;
            target *= 4;
            countR(matrix, row, col, totalS, target);            
        }
    }
}
```

```Java
// Wangshu
class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = matrix[i][j] == 1 ? Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1 : 0;
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
```
