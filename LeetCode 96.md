# LeetCode96

* Author：Wangshu Zhang
* Version：2020-06-23

# Problem: Unique Binary Search Trees

### Idea

![Image](https://github.com/youblue/LeetCode/blob/master/img_96.png)

### Code
```Java
class Solution {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        res.add(2);
        for (int i = 3; i <= n; i ++) {
            int x = 2 * res.get(i - 1);
            for (int j = i - 2; j >= 1; j --) {
                x += res.get(j) * res.get(i - 1 - j);
            }
            res.add(x);
        }
        return res.get(n);
    }
}
```
