# LeetCode186
* 作者：张望舒
* 版本：2018-02-12

# 题⽬描述 Reverse Words in a String II
* Input: char[] str
* Output: void

# 思路报告
1. 先问清楚时间复杂度和空间复杂度有没有要求？

    i. 审题发现题目要求in-place！

    ii. 从输出为void也能看出来我们不能新建额外的数组，只能在原数组上操作。意味着我们不能通过变换打印顺序来把原数组按要求reverse并存入新数组来做这道题目。
2. 原数组需要自己翻转成我们想要的样子。观察：

      the sky is blue

      blue is sky the

   规律是:

   i. 空格是识别出来每一个词语的唯一标志。

   ii. 如果把每一个词当成一个不变的单位，那么只是所有词需要倒序。

3. 第一个想法就是能否the和blue换，sky和is换（当然如果是奇数个词的话最中间的那个词就不用动了）。但是这样做的结果就是容易把原词组搞乱：

   i. the和blue交换，如果要保证the后面的空格位置不变，那就只能交换the和lue。

   ii. 同理如果要保证blue前面的空格位置不变，那the后面还应该加空格交换。

   任何一种情况都对sky和is的进一步读取造成了困难。

4. 所以一个关键的点是要保证句子的结构（空格仍然每个词语的唯一分割点）不能变！（可以类比堆操作里面heap的structure不能变，感觉思想上很类似）：
   i. 那只能整个先翻（这一点有试试看的成分，当然也不排除是之前的答案在脑子里太根深蒂固了）。
   ii. 翻完了再对每个词处理，这样就刨除了空格对翻转会切割词语的威胁(No need to worry about blanks any more, reverse becomes easy)。


### 代码

```Java
// Java
class Solution {
    public void reverseWords(char[] str) {
        int n = str.length;
        reverse(str, 0, n-1);

        int start = 0;
        for(int i = 0; i < n; i++) {
            if(str[i] != ' ')
                continue;
            reverse(str, start, i-1);
            start = i + 1;
        }
        reverse(str, start, n-1);
    }

    public void reverse(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
```


# 套路总结

* 一定注意审题，看准题目输入和输出要求。
* 有空间复杂度要求的题目往往比有时间复杂度要求的题目要难做一点。因为有时间复杂度要求往往用额外的数据结构就可以解决，但是有空间复杂度要求那就需要在算法上想的更巧妙一点。
* 有了思路之后仍然嫌麻烦不爱做，说明对字符数组以及字符串的操作需要熟练 ：（
* 对重复的操作可以写个小函数这样可以节省写代码时间和减少错误。
* 编程中各种typo和bug需要快速避免，比如while中不要忘记++／--（否则time limit exceed），判断条件“！=”还是“==”需要仔细一点。
* 其实代码还可以优化一下：for(int i = 0; i <= n; i++) if(str == '' || i == n)...
