# Leetcode 57. Insert Interval
@Author: Wangshu Zhang

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
        List<Interval> result = new ArrayList<>();
        for(Interval i:intervals) {
            if(newInterval == null || i.end < newInterval.start) {
                /******************************************************
                  i: start|---------|end
                                        newInterval: start|-----|end
                ******************************************************/
                result.add(i);

            } else if (i.start > newInterval.end) {
                /******************************************************
                  i:                           start|------------|end
                  newInterval: start|------|end
                ******************************************************/
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                /******************************************************
                  i:      start|---------------|end
                  newInterval: start|------------------|end

                  OR

                  i:              start|---------------|end
                  newInterval: start|-------------|end
                ******************************************************/
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(i.end, newInterval.end);
            }
        }
        if(newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }
}
```
