# LeetCode200
* 作者：张望舒
* 版本：2018-03-01

# 题目描述Number of Islands

# 思路报告
1. 这道题是数图上的连通分量个数问题。因为图是已经存好的了（一个矩阵），所以直接可以在遍历这个矩阵的过程中count。
2. 怎么遍历图呢？因为是输入是二维数组，用两个for循环访问每个元素即可。
3. 从一个起始点出发遍历图有两种方法，DFS和BFS。觉得在这道题里都可以用，所以就把两种方法都写出来了。BFS代码稍稍多一点。
4. 怎么标记一个点是被visit过了呢？这里有一个简单的方法就是不用标记，把已经visit过的'1'改成'0'就可以了。

```Java
// DFS
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1) {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
```

```Java
class Solution {
    class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Queue<Coordinate> q = new LinkedList<>();
        grid[i][j] = '0';
        q.offer(new Coordinate(i, j));

        while(!q.isEmpty()) {
            Coordinate head = q.poll();
            for(int k = 0; k < 4; k++) {
                Coordinate coor = new Coordinate(head.x + dx[k], head.y + dy[k]);
                if(inBound(grid, coor) ==  true && grid[coor.x][coor.y] == '1') {
                    grid[coor.x][coor.y] = '0';
                    q.offer(coor);
                }
            }
        }        
    }
    public boolean inBound(char[][] grid, Coordinate coor) {
        int m = grid.length;
        int n = grid[0].length;
        if(coor.x < 0 || coor.x > m-1 || coor.y < 0 || coor.y > n-1) {
            return false;
        }
        return true;
    }

}
```


# 套路总结
1. 要学会把问题分解为多个小任务，由相应的小函数来实现。
2. DFS关键是要逻辑正确，最终要的是写好递归的出口，否则会StackOverflow。
3. BFS相对代码量就大一些，如果不是求和最短路径之类步数有关的问题，至是图遍历的话写DFS更容易。
