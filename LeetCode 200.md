# LeetCode200

* Author：Wangshu Zhang
* Version：2020-04-08

# Problem: Number of Islands

### Code
```Java
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    res ++;
                    zeros(grid, i, j);
                }
            }
        }
        return res;
    }
    private void zeros(char[][] grid, int i, int j) {
        int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dxy) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                grid[x][y] = '0';
                zeros(grid, x, y);
            }
        }
    }
}
```
