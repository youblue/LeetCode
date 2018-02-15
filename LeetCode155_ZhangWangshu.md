# LeetCode155
* 作者：张望舒
* 版本：2018-02-14

# 题⽬描述 Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.

# 思路报告
1. 设计Min Stack的四个实现函数，其中关键是getMin()（其他的三个function可以就用stack来实现）。因为它要保证在stack push和pop的同时更新当前最小值。
2. 有关维护一个最小值的问题，其实脑子中蹦出来的第一个想法是额外建立一个min heap。这个最小堆是针对当前stack中所有元素的，即在每一次push和pop的时候都要更新。但是感觉使用堆会有坑：首先不确定要在里面存储几个元素，其次万一有重复的元素输入怎么办， 然后维护堆的成本可能会让时间复杂度不是O(n)，最重要的不能确定是否能和另一个stack同步。
3. 综合以上原因（其实最终要的是保持同步更新的原因），最简单最安全的方法是再建立一个同样的stack（Minimum Stack），和第一个stack（Brainless Stack）保持同步push和pop，但是向Minimum Stack每次push的值始终都是当前存储的所有元素的最小值，这样pop之后剩下元素中最顶上的同时也是Brainless Stack pop之后所有元素的最小值。

### 代码

```Java
// Using two stacks
class MinStack {
    Deque<Integer> dq1, dq2;
    public MinStack() {
        dq1 = new ArrayDeque<>();
        dq2 = new ArrayDeque<>();
    }

    public void push(int x) {
        dq1.addFirst(x);
        if(dq2.isEmpty()) {
            dq2.addFirst(x);
        } else {
            int top = dq2.peekFirst();
            if(x <= top) {
                dq2.addFirst(x);
            } else {
                dq2.addFirst(top);
            }
        }
    }

    public void pop() {
        dq1.removeFirst();
        dq2.removeFirst();
    }

    public int top() {
        return dq1.peekFirst();
    }

    public int getMin() {
        return dq2.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

# 套路总结

* 复习了类的成员变量和constructor函数的写法，应该避免语法上的错误。
* 学习了ArrayDeque类的各种方法，参见：
  * https://www.tutorialspoint.com/java/util/java_util_arraydeque.htm
