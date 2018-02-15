# LeetCode56
* 作者：张望舒
* 版本：2018-02-13

# 题⽬描述 Merge Intervals
* Input: List<Interval>
* Output: List<Interval>

# 思路报告
1. 这道题如果直接做的话，假设先将第一个interval存起来，那么第二个interval cur相对于第一个interval last有以下6种位置关系：

    （1）cur在last左边，完全不重合：

       cur.end < last.start

    （2）cur在last右边，完全不重合：

       cur.start > last.end

    （3）cur被包含在last中：

       cur.start >= last start && cur.end <= last.end

    （4）cur重合last偏左边的部分：

       cur.start <= last.start
       && cur.end >= last.start
       && cur.end <= last.end

    （5）cur重合last偏右边的部分：

       cur.start >= last.start
       && cur.start <= last.end
       && cur.end >= last.end

    （6）cur完全包含last：

       cur.start <= last.start && cur.end >= last.end

   这还是只有两个interval时候的情况，一旦之后的interval再加进来，这些interval之间的相对位置关系情况可能多到根本无法比较。所以这个直接比较的方法不可行。

2. 接下来就想，每加进来一个新的interval，有没有什么办法能让我们和之前的一个interval做比较、而不是和所有的interval比？那么就想到了如果新interval的start永远在老interval的start“偏右”边的话，那我只需要比较老interval的end是否小于新interval的start就可以知道是否重合。

3. 所以首先要对所有interval按start排序，保证后来的永远在之前interval的start的“偏右”方向。然后判断是否有overlap，如果没有那么存入result；如果有overlap，再根据两个interval end的位置来决定新组成的block的end位置（注意start不用再决定了！因为就是老interval的start！）

### 代码

// I have been working on it for more than 3 hours but still cannot get it AC...

```Java
// Java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
        return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());       

        List<Interval> result = new ArrayList<>();

        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                result.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end);
            }
        }

        return result;
    }
}
```


# 套路总结
* 参考了网上答案，因为不知道为什么，用for (int i = 1; i < intervals.size(); i++)的写法总会Time Exceed Limit。以下是我自己的代码：
```Java
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
        return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());       

        List<Interval> result = new ArrayList<>();

        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= last.end ){
                last.end = Math.max(last.end, cur.end);
            } else{
                result.add(last);
                last = cur;
            }
        }

        result.add(last);
        return result;
    }
}
```
* 因为时间有限，我还没有分析完老写法超时的原因，我会好好重新再做一遍。
