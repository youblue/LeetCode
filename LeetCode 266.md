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

```Python
class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        count = collections.Counter(s)
        chance = 0
        for c in count:
            if count[c] % 2 != 0:
                chance += 1
                if chance > 1:
                    return False
        return True
```
