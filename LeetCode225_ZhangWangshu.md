# LeetCode225
* 作者：张望舒
* 版本：2018-02-15

# 题目描述Implement Stack using Queues
*  Implement the following operations of a stack using queues.
  * push(x) -- Push element x onto stack.
  * pop() -- Removes the element on top of the stack.
  * top() -- Get the top element.
  * empty() -- Return whether the stack is empty.


# 思路报告
1. 因为Stack是LIFO，Queue是FIFO，所以用Queue来实现Stack时最重要的就是pop和top操作。如果将一组元素存在Queue里，那么top和pop的时候是要access队列的最后一个元素，而最后一个元素在队列中元素个数多于2的时候是直接拿不出来的。
2. 所以我的想法是再建立一个Queue，专门用来存放当前最后被push进来的元素。这样就是两个Queue: q1 and q2，q1就是用来存放当前最新push进来元素的队列，它永远只存一个元素，另外的所有元素都在q2里。
3. 这样各个函数就比较清楚了：
  * push(x): 如果q1为空那就放x在q1中，否则把q1仅有的一个元素先push到q2里再把x放入q1。
  * pop: 取出q1的元素，在返回前把q2的最后一个被push的元素放进q1（这里我把所有q2的除最后一个元素外的元素push进q1，然后再swap q1和q2）。
  * top: 无脑peek q1的元素。
  * empty: 只要q1为空即可，那就代表没有元素了。

### 代码

```Java
// Java
class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> dq1, dq2;
    public MyStack() {
        dq1 = new LinkedList<>();
        dq2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!dq1.isEmpty()) {
            dq2.offer(dq1.poll());
        }
        dq1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = dq1.poll();
        for(int i = 0; i < dq2.size()-1; i++) {
            dq1.offer(dq2.poll());
        }
        Queue<Integer> temp = dq1;
        dq1 = dq2;
        dq2 = temp;
        return x;
    }

    /** Get the top element. */
    public int top() {
        return dq1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return dq1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```


# 套路总结

* 这类题首先要审题，确定什么数据结构能用，什么数据结构不能用。
* 要熟练掌握各种数据结构的基本操作：add/offer/push, isEmpty(), poll, peek, size, remove, clear...
* 实现的方案有很多，要多想想alternative methods，比较各种方法时间复杂度优劣。
