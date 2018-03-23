# LeetCode76
* 作者：张望舒
* 版本：2018-03-13

# 题目描述Minimum Window Substring

# 思路报告
* 这道题可以用滑动窗口的思路来解决，在567题的基础上多加一层循环，但是用两个指针使复杂度为O(n)。
* 外层for循环s字符串, 内层while循环，条件是j < s.length() 和 !isValid(sourceHash, targetHash)：前者是s字符串下标边界，后者是一个函数，检查当前窗口中的substring是否包含了目标字符串中全部所需的字符，未满足则继续扩大窗口j++，同时更新sourceHash。
* 这里sourceHash，targetHash是整型数组int[]，因为ASCII码最多256个，因此用int[]可以作为简化的HashMap使用，key是char对应的int的值，value则是该char在substring中的出现个数。isValid函数则检查sourceHash是否全部包含了targetHash，256个字符一一对应，因此只需一重for循环，如果sourceHash[i] < targetHash[i]，则说明有字符未满足条件。
* min纪录满足条件的字符串长度，随时更新，用于输出满足最小长度的字符串。


### 代码

```Java
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }
        String result = "";

        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            targetHash[t.charAt(i)]++;
        }

        int i = 0, j = 0;
        for (i = 0; i < s.length(); ++i) {
            while (j < s.length() && !isValid(sourceHash, targetHash)) {
                sourceHash[s.charAt(j)]++;
                if (j < s.length()) {
                    j++;
                } else {
                    break;
                }
            }
            if (isValid(sourceHash, targetHash)) {
                if (min > j - i) {
                    min = Math.min(min, j - i);
                    result = s.substring(i, j);
                }
            }
            sourceHash[s.charAt(i)]--;
        }

        return result;
    }

    private boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < sourceHash.length; i++) {
            if (targetHash[i] > sourceHash[i]) {
                return false;
            }
        }
        return true;
    }

}

```
# 套路总结
* 这道题学习老师的程序，用int数组来作为hashTable，非常巧妙。
