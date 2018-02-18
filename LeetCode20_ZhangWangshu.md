## LeetCode20 Valid Parentheses

## 代码

```Java
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() < 2) {
            return false;
        }
        char[] input = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c:input) {
            if(c == '(') {
                stack.addFirst(')');
            } else if(c == '[') {
                stack.addFirst(']');
            } else if(c == '{') {
                stack.addFirst('}');
            } else if(stack.isEmpty()) {
                return false;
            } else {
                char x = stack.removeFirst();
                if(x != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
```
