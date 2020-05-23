# LeetCode986

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-22

# Problem: Interval List Intersections

### Code
```Java
// Yili
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int rowA = 0;
        int rowB = 0;
        int [][] res = new int[A.length + B.length][2];
        int rowRes = 0;
        while (rowA < A.length && rowB < B.length) {
            if (B[rowB][0] > A[rowA][1]) {   // case B5
                rowA++;
            } else if (B[rowB][1] < A[rowA][0]) { // case B1
                rowB++;
            } else if (B[rowB][0] >= A[rowA][0] && B[rowB][1] <= A[rowA][1]) { // case B3
                res[rowRes][0] = B[rowB][0];
                res[rowRes][1] = B[rowB][1];
                rowRes++;
                rowB++;
            } else if (A[rowA][0] >= B[rowB][0] && A[rowA][1] <= B[rowB][1]) { // case B6
                res[rowRes][0] = A[rowA][0];
                res[rowRes][1] = A[rowA][1];
                rowRes++;
                rowA++;
            } else if (A[rowA][0] <= B[rowB][1] && B[rowB][1] < A[rowA][1]) { // case B2
                res[rowRes][0] = A[rowA][0];
                res[rowRes][1] = B[rowB][1];
                rowRes++;
                rowB++;
            } else if (B[rowB][0] <= A[rowA][1] && A[rowA][1] < B[rowB][1]) { // case B4
                res[rowRes][0] = B[rowB][0];
                res[rowRes][1] = A[rowA][1];
                rowRes++;
                rowA++;
            }
        }
        return Arrays.copyOfRange(res, 0, rowRes);
    }
}
```

```Java
// Wangshu
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<int[]>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0] < B[j][0]) {
                if (B[j][0] > A[i][1]) {
                    i ++;
                    continue;
                }
                res.add(new int[]{B[j][0], Math.min(B[j][1], A[i][1])});
                if (B[j][1] > A[i][1]) {
                    B[j][0] = A[i][1] + 1;
                    i ++;
                } else {
                    j ++;
                }

            } else {
                if (B[j][1] < A[i][0]) {
                    j ++;
                    continue;
                }
                res.add(new int[]{A[i][0], Math.min(A[i][1], B[j][1])});
                if (A[i][1] > B[j][1]) {
                    A[i][0] = B[j][1] + 1;
                    j ++;
                } else {
                    i ++;
                }

            }
        }
        int n = res.size();
        int[][] ans = new int[n][2];
        for (int k = 0; k < n; k ++) {
            ans[k][0] = res.get(k)[0];
            ans[k][1] = res.get(k)[1];
        }
        return ans;
    }
}
```


```Java
// Best Version
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int rowA = 0;
        int rowB = 0;
        int [][] res = new int[A.length + B.length][2];
        int rowRes = 0;
        while (rowA < A.length && rowB < B.length) {
            int low = Math.max(A[rowA][0], B[rowB][0]);
            int high = Math.min(A[rowA][1], B[rowB][1]);
            if (low <= high) {
                res[rowRes][0] = low;
                res[rowRes][1] = high;
                rowRes++;
            }
            if (A[rowA][1] < B[rowB][1]) {
                rowA++;
            } else {
                rowB++;
            }
        }
        return Arrays.copyOfRange(res, 0, rowRes);
    }
}
```
