# Leetcode 239. Sliding Window Maximum
@Author: Wangshu Zhang

# Thoughts
* From the definition of sliding window, we know that the input has n elements, and we need to output n-k+1 values.
* I'd like to maintain a decreasing queue. When the difference between first element in Queue and the current index larger than k, which means we need to pop up the first element; At the same time when we slide to a new element, compare it with all previous elements in the queue, and delete all that are smaller than the current element. The following is a running example:

  Ex: 1 3 -1 -3 5 3 6 7

  i = 0: Queue = [1]

  i = 1: Queue = [3]

  i = 2: Queue = [3,-1], output: 3

  i = 3: Queue = [3, -1, -3], output: 3

  i = 4: Queue = [5], output: 5

  i = 5: Queue = [5, 3], output: 5

  i = 6: Queue = [6], output: 6

  i = 7: Queue = [7], output: 7


### Code
```Java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && i - q.getFirst() >= k) {
                q.removeFirst();
            }
            pushQueue(q, nums, i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.getFirst()];
            }
        }
        return res;
    }
    private void pushQueue(Deque<Integer> q, int[] nums, int i) {
        while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
            q.removeLast();
        }
        q.addLast(i);    
    }
}
```


```Python
class Solution:
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        q = collections.deque()
        res = []

        for i in range(len(nums)):
            while q and nums[q[-1]] <= nums[i]:
                q.pop()
            q.append(i)
            if q[0] == i - k:
                q.popleft()
            if i >= k - 1:
                res.append(nums[q[0]])

        return res
```



# Summary
* The time complexity is O(n), the space complexity is O(k). Pay attention that we store the index of array into the queue, instead of the array value itself.
