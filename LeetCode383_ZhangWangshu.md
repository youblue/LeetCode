## LeetCode383 Ransom Note


## 代码（本题是求subset，不是subsequence）
```Java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            Character key = magazine.charAt(i);
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key)+1);
            }
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            if(!map.containsKey(ransomNote.charAt(i))) {
                return false;
            } else if(map.get(ransomNote.charAt(i)) == 1) {
                map.remove(ransomNote.charAt(i));
            } else {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
            }
        }
        return true;
    }
}
```






## 如果是求subsequence的代码
* 要求ransomNote组成magazine中的顺序不能变

```Java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote != null && magazine == null || ransomNote.length() != 0 && magazine.length() == 0
           || ransomNote.length() > magazine.length()) {
            return false;
        }
        int left = 0, right = magazine.length() - 1;
        for(int i = 0; i < ransomNote.length(); i++) {
            if(ransomNote.charAt(i) == magazine.charAt(left)) {
                left++;
            } else if(ransomNote.charAt(i) == magazine.charAt(right)) {
                right--;
            } else {
                left++;
                right--;
                i--;
            }
            if(left > right) {
                return false;
            }
        }
        return true;

    }
}
```
