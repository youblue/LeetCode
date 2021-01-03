# LeetCode266

* Author：Wangshu Zhang
* Version：2021-01-01

# Problem: Palindrome Permutation

### Code
```Java
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (char c : s.toCharArray()) {
            map[c] ++;
            if (map[c] % 2 == 0) {
                count --;
            } else {
                count ++;
            }
        }
        return count <= 1;
    }
}
```
