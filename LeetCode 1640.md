# LeetCode1640

* Author：Wangshu Zhang
* Version：2021-01-01

# Problem: Check Array Formation Through Concatenation

### Code
```Java
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            for (int x : map.get(arr[i])) {
                if (x != arr[i]) {
                    return false;
                }
                i ++;
            }
        }
        return true;
    }
}
```
