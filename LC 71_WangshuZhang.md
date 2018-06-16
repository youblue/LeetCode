# Leetcode 71. Simplify Path
@Author: Wangshu Zhang

# Thoughts
* Obviously I first think about using a stack to store every command (imaging there's a "cd XX" command after each "/"). Because we need to first tract the most recent operation each time, so stack is very appropriate for this purpose.
* We can use the JAVA API method "split" to divide the whole path into separate string, then discuss different cases:
    * If the string is "" or ".", we can directly disregard it, do nothing;
    * If the string is "..", we need to pop the top string in the stack, but remember to check if the stack is empty. We only pop when the stack is empty, otherwise do nothing;
    * If the string is not any of the three above strings, then push it into the stack.
* Finally I also use JAVA API method "join" to join the remaining strings into a final path. Here don't forget to first add a "/" since every path starts with it.

### Code

```Java
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] words = path.split("/");
        Deque<String> stk = new ArrayDeque<>();
        for (String word : words) {
            if (word.equals(".") || word.equals("")) {
                continue;
            }
            if (word.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.removeLast();
                } else {
                    continue;
                }
            } else {
                stk.addLast(word);
            }
        }
        String res = "/" + String.join("/", stk);
        return res;
    }
}
```
# Summary
For me, the biggest harvest in this problem is that we can directly use "split" and "join" methods, which greatly simplify the codes.
