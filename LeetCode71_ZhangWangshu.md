# Leetcode 71. Simplify Path
@Author: Wangshu Zhang

```Java
class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq = new ArrayDeque<>();
        Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
        String[] words = path.split("/");
        for(String word : words) {
            if(!skip.contains(word)) {
                dq.addLast(word);
            } else if(word.equals("..") && !dq.isEmpty()) {
                dq.removeLast();
            }
        }
        String res = "/";
        res += String.join("/", dq);
        return res;
    }
}
```
