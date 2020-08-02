# LeetCode520

* Author：Wangshu Zhang
* Version：2020-08-01

# Problem: Detect Capital

### Code
```Java
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        boolean allUpperCase = true;
        if (Character.isLowerCase(word.charAt(0))) {
            allUpperCase = false;
        } else if (Character.isLowerCase(word.charAt(1))) {
            allUpperCase = false;
        }
        for (int i = 1; i < word.length(); i ++) {
            if (!allUpperCase && Character.isUpperCase(word.charAt(i))) {
                return false;
            }
            if (allUpperCase && Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
```
