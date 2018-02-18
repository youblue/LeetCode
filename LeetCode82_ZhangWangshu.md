# LeetCode82
* 作者：张望舒
* 版本：2018-02-17

# 题⽬描述 Remove Duplicates from Sorted List II
* Input: ListNode
* Output: ListNode

# 思路报告
1. 首先审题，输入是sorted linked list, 所以所有的duplicated numbers肯定都是堆在一起的。所以我们的目的就是把所有堆在一起的duplicated number都删掉。
2. 因为想one pass做完，所以肯定要一个while loop外循环每一个元素直到==null。
3. 另外考虑到链表从第一个元素开始就有可能是duplicated的，这样head就有可能被删掉，所以基本上要用到dummy node技巧，而且还要设立一个prev node用来指向当前元素的上一个元素（并初始化为dummy node）。这样准备工作就完成了，接下来就是one pass while loop了。
4. 在while loop的过程中，首先需要越过所有duplicated元素，找到第一个和它的next元素不相等的元素。这样可以用一个小while loop来实现，指针指向当前cur元素，在碰到所有next和当前cur相等的时后，指针都右移next。但是在跳出while之后我们还要记住经过了小while loop的cur元素是最后一个duplicated的元素，之后也要准备删掉的。
5. 还有另一个种情况是我们一直没有碰到duplicated元素，那么cur指向的值就不应该被删掉。那么怎么判断cur是duplicated的最后一个元素还是没有duplicated的元素呢？这里面prev指针就派上了用场：

   *  因为如果是dupicated元素，那么cur元素就在小while loop里面右移了，那么prev指针的next就不再是cur了。否则如果不是duplicated元素，prev的next就还是cur。
6. 搞清楚了cur是否是duplicated之后就简单了，
   * 如果不是duplicated那么prev和cur都右移就好，什么也不用动。
   * 如果是duplicated元素，那么prev的next需要越过cur直接指向cur的next，而且prev不变，cur右移变成cur.next。

7. 最后按标准写法return dummy.next，保证是返回新的链表头。


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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, prev = dummy;
        while(cur != null) {
            while(cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if(prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
```


# 套路总结

* 在链表问题中，如果觉得head可能会改变，一定要先定义dummy node指向head。一般也会需要一个prev node指向当前cur元素的上一个元素，并且需要初始化为dummy node。
* 链表题一般都是in place做，并且是one pass。所以最外圈肯定有一个while loop遍历所有元素，然后在遍历的过程中修改指向。所以关键是要找到可重复的修改模式。
* 个人觉得链表题最有用的思路就是在纸上画test cases然后手动run一下看看prev node，cur node和next node三者之间的关系，进而找到修改指针的方式。
* 最后返回是dummy.next。
