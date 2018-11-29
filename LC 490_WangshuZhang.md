# Leetcode 490. The Maze
@Author: Wangshu Zhang
@Date: Nov 22, 2018

# Thoughts
* BFS method

### Code

```Java
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        q.addLast(start);
        isVisited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : directions) {
                int xx = x, yy = y;
                while (xx >= 0 && xx < maze.length && yy >= 0 && yy < maze[0].length && maze[xx][yy] != 1) {
                    xx += dir[0];
                    yy += dir[1];
                }
                xx -= dir[0];
                yy -= dir[1];
                if (xx == destination[0] && yy == destination[1]) {
                    return true;
                }
                if (isVisited[xx][yy] == false) {
                    q.addLast(new int[]{xx, yy});
                    isVisited[xx][yy] = true;
                }
            }
        }
        return false;
    }
}
```

# Summary
* When encountering a graph problem, always ask: what is node, what is edge, what is greedy strategy?
