# LeetCode252

* Author：Wangshu Zhang
* Version：2020-11-01

# Problem: Meeting Rooms

### Code
```Java
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int end = Integer.MIN_VALUE;
        for (int[] interval :intervals) {
            if (interval[0] < end) {
                return false;
            }
            end = Math.max(end, interval[1]);
        }
        return true;
    }
}
```
