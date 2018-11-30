# Leetcode 60. Permutation Sequence
@Author: Wangshu Zhang

@Date: Nov 29, 2018

# Thoughts
* First following the way of "46. Permutation", I always got a "TLE" error.
* The right way should be: only calculate the Kth permutation!
* I think this reference is more understandable:
https://blog.csdn.net/eddy_liu/article/details/50799559

  1）第k个排列的第一个元素在0-n中的位置为（k-1）/（n-1）！

  2）在剩下的元素中继续找第一个；

  3）依此类推。



### Code
```Java
// AC code
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder("");
        StringBuilder s = new StringBuilder("");
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        int factorial = factorial(n);
        for (int i = n; i >= 1; i--) {
            factorial /= i;
            int index = (k - 1) / factorial;
            res.append("" + s.charAt(index));
            k -= index * factorial;
            s = s.deleteCharAt(index);
        }
        return res.toString();
    }
    private int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}

```


```Java
// My TLE Solution
class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        ArrayList<String> res = new ArrayList<>();
        dfs(n, k, res, new StringBuilder(""), 0);
        return res.get(k - 1);
    }
    private void dfs(int n, int k, ArrayList<String> res, StringBuilder path, int count) {
        if (path.length() == n) {
            res.add(new String(path.toString()));
            count++;
            if (count == k) {
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (path.toString().contains(Integer.toString(i))) {
                continue;
            }
            path.append(i);
            dfs(n, k, res, path, count);
            path.deleteCharAt(path.length()-1);
        }

    }
}
```

# Summary
*
