# LeetCode278

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-04-30

# Problem: First Bad Version

### Code
```Java
// Yili

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int med = start + (end - start >> 1);
            if (isBadVersion(med)) {
                end = med;
            } else {
                start = med + 1;
            }
        }
        return start;
    }
}



/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int med = start + (end - start >> 1);
            if (isBadVersion(med)) {
                end = med;
            } else {
                start = med + 1;
            }
        }
        return start;
    }
}
```

```Java
// Wangshu
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int med = start + (end - start) / 2;
            if (isBadVersion(med)) {
                end = med;
            } else {
                start = med + 1;
            }
        }
        return start;
    }
}
```
