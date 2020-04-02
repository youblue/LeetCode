# LeetCode136

* Author：Wangshu Zhang
* Version：2020-04-01

# Problem: Single Number

### Code
```Java
// Java Version
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        for (int x : set) {
            return x;
        }
        return -1;
    }
}
```
