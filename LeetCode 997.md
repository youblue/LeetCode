# LeetCode997

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-10

# Problem: Find the Town Judge

### Code
```Java
// Yili
class Solution {
    public int findJudge(int N, int[][] trust) {

        int[] votes = new int[N + 1];  // you loose one vote by voting others, and get one vote by being voted by others
        for (int i = 0; i < trust.length; i++) {
            votes[trust[i][1]]++;
            votes[trust[i][0]]--;
        }
        for (int j = 1; j <= N; j++) {
            if (votes[j] == N - 1) {
                return j;
            }
        }
        return -1;
    }
}
```

```Java
// Wangshu
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] matrix = new int[N+1][N+1];
        int[] candidates = new int[N];
        Arrays.fill(candidates, 1);
        for (int[] pair : trust) {
            int a = pair[0];
            int b = pair[1];
            candidates[a-1] = 0;
            matrix[a][b] = 1;
        }
        int count = 0;
        int candidate = -1;
        for (int i = 0; i < candidates.length; i ++) {
            if (candidates[i] == 1) {
                count ++;
                if (count == 2) {
                    return -1;
                }
                candidate = i + 1;
            }
        }
        if (candidate == -1) {
            return -1;
        }
        for (int i = 1; i <= N; i ++) {
            if (i != candidate && matrix[i][candidate] == 0) {
                return -1;
            }
        }
        return candidate;
    }
}

// Simpler
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }
        int[] score = new int[N + 1];
        for (int[] pair : trust) {
            score[pair[0]] --;
            score[pair[1]] ++;
        }
        for (int i = 1; i <= N; i ++) {
            if (score[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
```
