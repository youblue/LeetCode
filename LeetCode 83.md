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

```Python
# Python version:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        while head:
            while head.next and head.next.val == head.val:
                head = head.next
            prev.next = head
            prev = prev.next
            head = head.next
        return dummy.next
```
