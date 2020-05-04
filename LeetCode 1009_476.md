# LeetCode1009_476

* Author：Wangshu Zhang
* Version：2020-05-03

# Problem: Complement of Base 10 Integer / Number Complement

### Code
```Java
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
