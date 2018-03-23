# LeetCode542
* 作者：张望舒
* 版本：2018-03-08

# 题目描述01 Matrix

# 思路报告

1. 这道题用BFS做和DFS做都非常简单，思路和Number of Island很像，都属于染色问题。但是因为这道题是in place update距离，所以有必要先对matrix进行pre-set和初始化：先遍历整个矩阵，把为0的点加到Queue里，另外将为1的点染色为Inf（这样做的原因是便于我们之后计算最短距离，和当前的值相比即可）。
2. 所以对Queue出队列的每一个元素，依次更新它的四向邻接元素。如果邻接元素已经是较小值，那么不要打扰；否则就更新为最小值，并且将其加到Queue里。

### 代码

```Java
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1) {
                    continue;
                }
                if(matrix[x][y] <= matrix[cur[0]][cur[1]] + 1) {
                    continue;
                } else {
                    matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return matrix;
    }
}
```
# 套路总结

* 熟悉染色问题，BFS和DFS解法。
* 可以通过pre-set考虑优化。
