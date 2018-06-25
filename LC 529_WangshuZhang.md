# Leetcode 529. Minesweeper
@Author: Wangshu Zhang

# Thoughts
* Imagine we are now playing this game, and after we click a square, there are only several cases to be considered:
    * If clicking on "M", then only change that square to "X", return.
    * Otherwise, we should have clicked on 'E', then we need to update itself and possibly neighbors. There are two cases as well:
        * If it is near to at least one mine, then need to update board[x][y] to the count of mines, no further exploration needed.
        * Otherwise, if its neighbors do not contain mines, then update board[x][y] to 'B', and recursively explore its neighbors. 

### Code
```Java
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0 || click.length != 2) {
            return board;
        }
        int n = board.length, m = board[0].length, x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
                        {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        dfs(board, n, m, x, y, dirs);
        return board;
    }
    private void dfs(char[][] board, int n, int m, int x, int y, int[][] dirs) {
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1 || board[x][y] != 'E') {
            return;
        }
        int count = countMine(board, n, m, x, y);
        if (count > 0) {
            board[x][y] = (char)(count + '0');
        } else {
            board[x][y] = 'B';
            for (int[] dir : dirs) {
                dfs(board, n, m, x + dir[0], y + dir[1], dirs);
            }
        }
    }
    private int countMine(char[][] board, int n, int m, int x, int y) {
        int cnt = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'M') {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
```

# Summary
* At first I feel a little confused about the 'E' state, and spent pretty a lot time reading the problem. But I think I understand it now, 'E' just provides a starting point for us to do DFS.
