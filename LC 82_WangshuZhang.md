# Leetcode 82. Remove Duplicates from Sorted List II
@Author: Wangshu Zhang

### Code

```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        // eg: dummy -> 1 -> 2 -> 2 -> 2 -> 3       
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            if (prev.next == head) {
                prev = prev.next;
            } else {
                prev.next = head.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
```
