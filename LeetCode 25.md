# LeetCode25

* Author：Wangshu Zhang
* Version：2020-02-24

# Problem: Reverse Nodes in k-Group

# Similar:
- 206: Reverse Linked List
- 92: Reverse Linked List II

# Thoughts
* If we know how to solve LC 92, this problem is just a generalization of it.


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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            int i = 1;
            while (curr.next != null && i < k) {
                curr = curr.next;
                i ++;
            }
            if (i < k) {
                break;
            }
            ListNode next = curr.next;
            prev.next = curr;
            reverse(head, k);
            head.next = next;
            prev = head;
            head = next;
            curr = next;
        }
        return dummy.next;
    }
    private static void reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i ++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
```



# Summary
* Try to find the pattern that is loop invariant.
* Usually we need to define dummy node, prev, curr, next. If possible just define all of them.
