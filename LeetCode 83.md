# LeetCode83

* Author：Wangshu Zhang
* Version：2021-01-05

# Problem: Remove Duplicates from Sorted List


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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            prev.next = head;
            prev = prev.next;
            head = head.next;
        }
        return dummy.next;
    }
}
```
