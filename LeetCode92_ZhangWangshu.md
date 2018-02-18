## LeetCode 92 Reverse Linked List II

## 代码

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        // 1. Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // Scanner

        // 2. For first m-1 nodes, skip
        for(int i = 1; i < m; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        ListNode next = cur.next;

        // 3. For m~n nodes, keep lastTail and tail while adding new head in each round
        // dummy -> ... -> prev -> cur -> next -> next.next -> ...
        for(int i = m; i < n; i++) {
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
}
```
