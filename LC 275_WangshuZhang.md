# Leetcode 275. H-Index II
@Author: Wangshu Zhang

# Thoughts
* If the array is sorted, the solution will be trivial, just removing the sorting step in LC274: H-Index will be accepted.
* The follow-up question is: Could you solve it in logarithmic time complexity? So I first think about binary search.

### Code
```Java
// Based on sorted array
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}
```

```Java
// Binary sort
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int start = 0, end = citations.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] < citations.length - mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (citations[start] >= citations.length - start) {
            return citations.length - start;
        }
        return 0;
    }
}
```

# Summary
* There are some useful corner cases that needs taking consideration:

[0]: Expected output: 0

[0, 0]: Expected output: 0

[100]: Expected output: 1
