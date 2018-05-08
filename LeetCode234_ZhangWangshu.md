# Leetcode 234. Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        // 1. Find mid point
        ListNode slow = head, fast = head;
        while(slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        // 2. Reverse the second half
        ListNode p = mid.next, prev = null;
        while(p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        mid.next = prev;

        // 2. Compare first half and second half
        slow = head;
        fast = mid.next;
        while(fast != null) {
            if(slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
```
