# LeetCode3

* Author：Wangshu Zhang
* Version：2020-03-22

# Problem: Longest Substring Without Repeating Characters

# Thoughts
https://www.youtube.com/watch?v=mtHelVTLKRQ

My example: abcadbcbb

### Code

```Java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j ++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return res;
    }
}
```

```Java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0;
        while (i < array.length && j < array.length) {
            if (set.add(array[j])) {
                res = Math.max(set.size(), res);
                j ++;
            } else {
                set.remove(array[i ++]);
            }
        }
        return res;
    }
}
```
