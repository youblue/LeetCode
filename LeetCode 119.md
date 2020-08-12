# LeetCode119

* Author：Wangshu Zhang
* Version：2020-08-12

# Problem: Pascal's Triangle II

### Code
```Java
// Solution 1
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i ++) {
            for (int j = i - 1; j >= 1; j --) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}
```

```Java
// Math Solution
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int k = 1; k <= rowIndex; k ++) {
            res.add((int) ((res.get(res.size() - 1) * (long) (rowIndex - k + 1)) / k));
        }
        return res;
    }
}
```
