# LeetCode143
* 作者：张望舒
* 版本：2018-02-13

# 题⽬描述 Reorder List
* Input: ListNode head
* Output: void

# 思路报告
1. 先问清楚时间复杂度和空间复杂度有没有要求？

    i. 审题发现题目要求in-place！

    ii. 要从两头往中间读，那么就需要改变链表的指针指向顺序。

2. 改变链接的指针应该是有规律的，先从画图看看能不能找到这个规律。

    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 变成

    1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4

示意图：

    1 --------------------------> 7

         2 ----------------> 6

              3 ------> 5

                   4

                   <-----

              <---------------   

         <-------------------------

感觉形成了一个卷状的“稻草堆”。

3. 从上图中能看出，维持1，2，3，4分别连了7, 6, 5, 4（4指向自己省略）。如果链表原本就是1 -> 2 -> 3 -> 4 -> 7 -> 6 -> 5，那么其实题目要求就是把这个链表的中点前的元素和中点后的元素对应相连，最后连中点。如果链表有偶数个元素，那也是有一个假想的中点，中点前的元素和中点后的元素

4. 所以现在有两个问题：

   i. 能不能找到链表的中点？
   * 可以，快慢指针法。

   ii. 能不能把1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7变成1 -> 2 -> 3 -> 4 -> 7 -> 6 -> 5？
   * 可以，翻转中点后的一半，中点前不变。

5. 解决了4之后，按照想法3把链表重新链接即可。

### 代码

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        // 1. Find middle point: mid
        ListNode p1 = head, p2 = head.next;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode mid = p1;

        // 2. Reverse second half after middle point
        p1 = mid.next;
        ListNode prev = null;
        while(p1 != null) {
            ListNode next = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = next;
        }
        mid.next = prev;

        // 3. Merge
        p1 = head;
        p2 = mid.next;
        while(p2 != null && p1 != mid){
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
        if(p1 == mid) {
            p1.next = p2;
        }

    }
}
```


# 套路总结
* 单向链表如果链接prev节点但是又不给前向指针的情况下需要考虑翻转。
* 求链表中点可以使用快慢指针法。
* 链表题需要画图和快速反应和熟练coding。
