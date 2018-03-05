# LeetCode23
* 作者：张望舒
* 版本：2018-03-04

# 题目描述Merge k Sorted Lists


# 思路报告
1. 在做这道题之前，先做了一下LeetCode 21： Merge Two Sorted Lists。因为感觉就和3Sum利用了2Sum的解法一样，Merge K Sorted Lists应该也可以使用Merge Two Sorted Lists，把它当成一个base function。

2. 如果先merge前两个list，然后再和第三个list merge，然后再和第四个。。。这样依次做的时间复杂度是T(n) = (2n+3n+4n+...+(k-1)n) = O(nK^2)。但是如果利用二分的思想，让这些list两两merge，然后再不断merge在一起，T(n) = O(nklogK)，会更加有效率。

3. 所以用Divide and Conquer的思想不断二分lists，直到分成可以用Merge Two Lists解决的子问题，然后再通过recursion的返回值拼接回整体的merged结果。

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        return helper(lists, 0, n-1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode list1 = helper(lists, start, mid);
        ListNode list2 = helper(lists, mid+1, end);
        return mergeTwoLists(list1, list2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

}
```

# 套路总结

* 学会了写输入是LinkedList的Merge 2 Sorted List，因为链表长度不知道，所以用recursion的写法比较简单。
* 使用Divide and Conquer，注意Base Case的写法，将K个问题转换成2个问题来解决，2个问题的解不断返回拼接成K个问题的解。
