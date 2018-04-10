# LeetCode56
* Author：Wangshu Zhang
* Version：2018-04-10

# Problem: Merge Intervals

# Thoughts
* First I got the idea that we need to sort all intervals by their start positions, because otherwise there are two many cases to consider between each of two intervals. The time spent on sorting is worth the time.
* If the all the intervals are sorted, then things become simpler. We just need to compare current interval with the previous one, and there are three possible scenarios:
    *  curr.start > prev.end: Current interval has no overlap with the previous one, we can directly add it into the result.
    * curr.start <= prev.end & curr.end <= prev.end: Current interval is completely covered by the previous one, and we can disregard it.
    * curr.start <= prev.end & curr.end > prev.end: There are incomplete overlap between the two intervals. Since the previous one has been added to the result, so we need first remove it, then merge with the current one, and finally add to the result. Here do not forget to update the current start point by that of the merged interval!
* Actually the most difficult part for me is still how to write Lambda function in the sort function. It is not easy to remember for me, so I need to practice more...

### Code

```Java
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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        intervals.sort(Comparator.comparing( (Interval x) -> x.start) );
        /*
        for(Interval x : intervals) {
            System.out.println(x.start);
        }
        */
        Interval prev = new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Interval curr : intervals) {
            if(curr.start > prev.end) {
                res.add(new Interval(curr.start, curr.end));

            } else if(curr.end <= prev.end) {
                continue;
            } else {
                res.remove(res.size() - 1);
                //System.out.println(prev.start);
                //System.out.println(curr.end);
                res.add(new Interval(prev.start, curr.end));
                curr.start = prev.start;
            }
            prev = curr;
        }
        return res;
    }
}
```
# Summary
* Second time to do this problem, came to the idea soon, but wrote a long time...
