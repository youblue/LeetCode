# LeetCode328

* Author：Yili Zhao & Wangshu Zhang
* Version：2020-05-16

# Problem: Odd Even Linked List

### Code
```Java
// Yili
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev1 = head, prev2 = head.next, dummy = prev2;
        while (prev2 != null && prev2.next != null) {
            prev1.next = prev1.next.next;
            prev1 = prev1.next;
            prev2.next = prev2.next.next;
            prev2 = prev2.next;
        }
        prev1.next = dummy;
        return head;
    }
}
```

```Java
// Wangshu
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev1 = head, prev2 = head.next, dummy = prev2;
        while (prev2 != null && prev2.next != null) {
            prev1.next = prev1.next.next;
            prev1 = prev1.next;
            prev2.next = prev2.next.next;
            prev2 = prev2.next;
        }
        prev1.next = dummy;
        return head;
    }
}
```
