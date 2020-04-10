# LeetCode844

* Author：Wangshu Zhang
* Version：2020-04-08

# Problem: Backspace String Compare

### Code
```Java
// (1) Naive method
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        for (int i = 0; i < S.length(); i ++) {
            if (S.charAt(i) == '#') {
                if (!stk1.empty()) {
                    stk1.pop();
                }
            } else {
                stk1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i ++) {
            if (T.charAt(i) == '#') {
                if (!stk2.empty()) {
                    stk2.pop();
                }
            } else {
                stk2.push(T.charAt(i));
            }
        }
        if (stk1.size() != stk2.size()) {
            return false;
        }
        while (!stk1.empty()) {
            if (stk1.pop() != stk2.pop()) {
                return false;
            }
        }
        return true;
    }
}
```

```Java
// (2) Follow-up: Can you solve it in O(N) time and O(1) space?

/* Reference: https://www.cnblogs.com/grandyang/p/10447783.html

用变量i和j分别指向S和T串的最后一个字符的位置。
用变量 cnt1 和 cnt2 来分别记录S和T串遍历过程中连续出现的井号的个数。

*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS ++;
                    i --;
                } else if (skipS > 0) {
                    skipS --;
                    i --;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT ++;
                    j --;
                } else if (skipT > 0) {
                    skipT --;
                    j --;
                } else {
                    break;
                }
            }
            if (i < 0 || j < 0) {
                return i == j;
            }
            if (S.charAt(i --) != T.charAt(j --)) {
                return false;
            }
        }
        return true;
    }
}
```
