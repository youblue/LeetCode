# Leetcode 247. Strobogrammatic Number II
@Author: Wangshu Zhang

@Date: Mar 10, 2019

### Code

```Java
// Recursion
class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    private List<String> helper(int n, int target_n) {
        if (n == 0) {
            return new ArrayList(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList(Arrays.asList("0", "1", "8"));
        }
        List<String> sub = helper(n - 2, target_n);
        List<String> res = new ArrayList<>();
        for (String str : sub) {
            if (n != target_n) {
                res.add("0" + str + "0");
            }
            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }
        return res;
    }
}
```


```Java
// Iteration
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n % 2 == 0) {
            res.add("");
        } else {
            res.add("0");
            res.add("1");
            res.add("8");
        }
        while (n >= 2) {
            List<String> tmp = res;
            res = new ArrayList<String>();
            for (String str : tmp) {
                if (n > 3) {
                    res.add("0" + str + "0");
                }
                res.add("1" + str + "1");
                res.add("8" + str + "8");
                res.add("6" + str + "9");
                res.add("9" + str + "6");
            }
            n -= 2;
        }
        return res;
    }
}
```

# References
* https://yeqiuquan.blogspot.com/2017/06/247-strobogrammatic-number-ii.html
