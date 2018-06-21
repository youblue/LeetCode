# Leetcode 286. Walls and Gates
@Author: Wangshu Zhang

# Thoughts
* This problem is a typical DFS/BFS problem in a graph, where here the graph is a 2-dimensional matrix. This problem is easier than "Number of Islands" because we do not need to count the number of connected components, instead, we just use traverse all reachable elements in the graph, and all done.
* One trick is that to make sure all the updated distance is minimal, we need to traverse from destination to the source (here is from gate to every node, i.e., starting from the "0" elements).

### Code
```Java
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i, j, 0);
                }
            }
        }
    }
    private void helper(int[][] rooms, int i, int j, int dist) {
        if (i < 0 || i > rooms.length - 1 || j < 0 || j > rooms[0].length - 1) {
            return;
        }
        if (rooms[i][j] == -1 || rooms[i][j] < dist) {
            return;
        }
        rooms[i][j] = dist;

        helper(rooms, i - 1, j, dist + 1);
        helper(rooms, i + 1, j, dist + 1);
        helper(rooms, i, j - 1, dist + 1);
        helper(rooms, i, j + 1, dist + 1);
    }
}
```

# Summary
* This problem can also be done using BFS, but the code of DFS is simpler.
