# LeetCode402

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-12

# Problem: Remove K Digits

### Code
```Java
// Yili
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        boolean allAsc = false; // check if the string is purely ascending
        boolean deletedThisRound = false;  //check if any digit has been removed in this iteration
        int deletedDigits = 0; // check how many digits have been removed in total
        while (deletedDigits < k) {
            if (allAsc) { // if the num is purely ascending, remove the last (k - deletedDigits) digits
                num = num.substring(0, num.length() - (k - deletedDigits));
                break;
            } else { // remove any digit if its following digit is small than it
                int i = 0;
                while (i < num.length() - 1) {
                    if (deletedDigits < k && num.charAt(i + 1) < num.charAt(i)) {
                        num = num.substring(0, i) + num.substring(i + 1);
                        deletedDigits++;
                        deletedThisRound = true;
                        if (i != 0) {
                            i--;
                        }
                    } else {
                        i++;
                    }       
                }
                if (!deletedThisRound) { // if no digit is removed in an iteration, the num is purely ascending now
                    allAsc = true;
                }
                deletedThisRound = false;
            }
        }
        int j = 0;
        while (j < num.length()) { // remove any leading '0's
            if (num.charAt(j) != '0') {
                return num.substring(j);
            }
            j++;
        }
        return "0";
    }
}
```

```Java
// Wangshu
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            int x = c - '0';
            while (!dq.isEmpty() && k > 0 && x < dq.getLast()) {
                dq.removeLast();
                k --;
            }
            dq.addLast(x);
        }
        String res = "";
        while (dq.size() > 1 && dq.getFirst() == 0) {
            dq.removeFirst();
        }
        while (dq.size() > k) {
            res += dq.removeFirst();
        }
        return res;
    }
}
```
