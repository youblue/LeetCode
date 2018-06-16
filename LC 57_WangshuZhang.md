# Leetcode 57. Insert Interval
@Author: Wangshu Zhang

# Thoughts
* There are three relationships between the newInterval and the old ones: before they meet, during they meet, and after they meet:
    * Before meet: newInterval.start > interval.end
    * During meet: newInterval.start <= interval.end, there are also two cases:
        * newInterval.end < interval.start:
        * newInterval.end >= interval.start:
    * After meet: don't need to consider newInterval since it has been already processed.
* Here I merge the cases of "Before meet" and "After meet" by setting newInterval to NULL in the "During meet" process.

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        for (Interval interval : intervals) {
            if (newInterval == null || interval.end < newInterval.start) {
                res.add(interval);
            } else if (interval.start > newInterval.end) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res;
    }
}
```
# Summary
This problem is pure coding and also carefully think about different scenarios.
