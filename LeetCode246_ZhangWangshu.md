## LeetCode246 Strobogrammatic Number


## 代码
```Java
class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) {
            return true;
        }
        Map<Character, Character>map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');


        int n = num.length();
        int left = 0, right = n - 1;
        while(left <= right) {
            if(!map.containsKey(num.charAt(left))) {
                return false;
            }
            if(num.charAt(right) != map.get(num.charAt(left))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```
