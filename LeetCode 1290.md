# LeetCode1290

* Author：Wangshu Zhang
* Version：2020-11-01

# Problem: Convert Binary Number in a Linked List to Integer

### Code
```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int res = head.val;
        while (head.next != null) {
            res = 2 * res + head.next.val;
            head = head.next;
        }
        return res;
    }
}
```
