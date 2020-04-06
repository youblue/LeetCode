# LeetCode49

* Author：Wangshu Zhang
* Version：2020-04-06

# Problem: Group Anagrams

### Code
```Java
// Sort method:
/*
Time: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.

Space: O(NK), the total information content stored in map.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted_str = new String(ch);
            map.putIfAbsent(sorted_str, new ArrayList<String>());
            map.get(sorted_str).add(str);
        }
        for (List<String> arr : map.values()) {
            res.add(arr);
        }

        return res;
    }
}
```

```Java
// Simpler, map can be transferred to array simply, no need to loop
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
```

```Java
// Count method
/*
Time: O(NK)

Space: O(NK)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a'] ++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
```
