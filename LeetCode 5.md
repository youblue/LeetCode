# LeetCode5

* Author：Wangshu Zhang
* Version：2020-04-07

# Problem: Longest Palindromic Substring

### Code
```Java
// (1) Dynamic Programming method
/*
http://www.goodtecher.com/leetcode-5-longest-palindromic-substring/
https://www.techiedelight.com/longest-palindromic-subsequence-using-dynamic-programming/
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (boolean[]row : dp) {
            Arrays.fill(row, false);
        }

        // Initialize
        for (int i = 0; i < n - 1; i ++) {
            dp[i][i] = true;
            dp[i][i + 1] = dp[i + 1][i] = s.charAt(i) == s.charAt(i + 1) ? true : false;
        }
        dp[n - 1][n - 1] = true;

        // Run DP
        int left = 0, right = 0;
        for (int j = 1; j < n; j ++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] == true && j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
```

```Java
// (2) Expand method
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i ++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }
    private int expand(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L --;
            R ++;
        }
        return R - L - 1;
    }
}
```
