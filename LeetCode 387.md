# LeetCode387

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-05

# Problem: First Unique Character in a String

### Code
```Java
// Yili
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] sArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (sArr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
```

```Java
// Wangshu
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = s.length() - 1; i >= 0; i --) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) == 1) {
                res = i;
            } else if (s.charAt(res) == s.charAt(i)) {
                res = -1;
            }
        }
        return res;
    }
}
```
