# LeetCode476

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-03

# Problem: Number Complement

### Code
```Java
// Yili
class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;
        int max = 1;
        int temp = num;
        while (temp != 0) {
            max *= 2;
            temp = temp >> 1;
        }
        max--;
        return max - num;
    }
}
```

```Java
// Wangshu
class Solution {
    public int findComplement(int num) {
        int total = 2;
        int temp = num;
        while (temp > 1) {
            temp /= 2;
            total *= 2;
        }
        return total - num - 1;
    }
}
```
