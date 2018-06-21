# Leetcode 286. Number of Islands II
@Author: Wangshu Zhang

# Thoughts
* This problem is very similar to LC 200: Number of Islands, except for the land is dynamically changed. The question requires time complexity O(k log mn), which indicates that we should use the Union-Find algorithm to solve because if there's k operations, either Union or Find, are applied to m*n elements, the total run time is just O(k log mn).

### Code
```Java
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;
        for (int[] pos : positions) {
            count++;
            int num = pos[0] * n + pos[1];
            parent[num] = num;

            for (int k = 0; k < 4; k++) {
                int x = pos[0] + dx[k];
                int y = pos[1] + dy[k];
                if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                    continue;
                }
                if (parent[x * n + y] != -1) {
                    int curParent = getParent(num, parent);
                    int neiParent = getParent(x * n + y, parent);
                    if (curParent != neiParent) {
                        parent[curParent] = neiParent;
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    private int getParent(int i, int[] parent) {
        while (i != parent[i]) {
            i = parent[parent[i]];
        }
        return i;
    }
}
```

# Summary
* The Find part of union we can use template (the getParent function), which is almost not changed in different problems.
