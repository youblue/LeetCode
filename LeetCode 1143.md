# LeetCode1143

* Author：Wangshu Zhang
* Version：2020-04-25

# Problem: Longest Common Subsequence

### Code

```Java
// Time Limit Exceed!!!
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length(), text2.length());
    }
    private int lcs(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return 1 + lcs(text1, text2, n - 1, m - 1);
        } else {
            return Math.max(lcs(text1, text2, n, m - 1), lcs(text1, text2, n - 1, m));
        }
    }
}
```

```Java
// Accepted Solution: Dynamic programming
// Reference: http://gitlinux.net/2020-01-06-(1143)-longest-common-subsequence/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

```
