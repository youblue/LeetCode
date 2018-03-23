# LeetCode23
* 作者：张望舒
* 版本：2018-03-04

# 题目描述Merge k Sorted Lists


# 思路报告
1. 这道题看似讲了长长的扫雷规则，其实和Number of Islands很像：首先输入形式很像，都是二维数组。其次遍历方式很像，Number of Islands是四个方向的，这里是八个方向的，可以同样建立一个方向数组并且要注意边界条件。然后也是在边遍历的时候边更新输入数组。
2. 所以虽然数组中的元素有'M'，'E'，'B'，digits('1' to '8')，'X'几种可能，但是需要遍历处理的只有'E'元素。因为如果是'M'，直接把该元素变成'X'并game over；如果是'B'或digits，扫雷的时候不会再点击到这个元素。
3. 模仿Number of Islands的思路，碰到是'E'的元素看看是显示雷数（Click的地方在雷周围8个点之中）还是显示'B'（需要进一步的DFS来标记周围点）。

### 代码

```Java
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0 || click.length != 2) {
            return board;
        }
        int x = click[0], y = click[1], m = board.length, n = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            dfs(board, x, y, m, n, dirs);
        }
        return board;
    }
    private void dfs(char[][] board, int x, int y, int m, int n, int[][] dirs) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') return;
        int mine = adjMine(board, x, y, m, n);
        if (mine > 0) {
            board[x][y] = (char) ('0' + mine);
        } else {
            board[x][y] = 'B';
            for (int[] d : dirs) {
                dfs(board, x + d[0], y + d[1], m, n, dirs);
            }
        }
    }
    private int adjMine(char[][] board, int x, int y, int m, int n) {
        int cnt = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (0 <= i && i < m && 0 <= j && j < n && board[i][j] == 'M')
                    cnt++;
            }
        }
        return cnt;
    }
}
```

# 套路总结

* 这道题学会的就是将当前题目转化成已有的题目。
* 把每一步写成一个小函数，将大任务分解。
