# LeetCode82

* Author：Wangshu Zhang
* Version：2021-01-05

# Problem: Remove Duplicates from Sorted List II


### Code
```Java
// (1) My solution using extra time and space
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
        int[] count = new int[201];
        while (head != null) {
            count[head.val + 100] ++;
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        for (int i = 0; i < 201; i ++) {
            if (count[i] == 1) {
                prev.next = new ListNode(i - 100);
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
```


```Java
// (2) Optimal in time and space
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
        dummy.next = head; // This line is very important, cannot be deleted !!!
        ListNode prev = dummy;
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

```Python
# Python version

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
            if prev.next == head:
                prev = prev.next
            else:
                prev.next = head.next
            head = head.next
        return dummy.next
```
