# LeetCode307
* Author：Wangshu Zhang
* Version：2018-03-20

# Problem: Range Sum Query - Mutable

# Thoughts
* This problem appears really hard to me. I only thought about brute force solution at first.
  * Given a start point and an endpoint, taking sum of this interval needs O(n) time, and whenever an update call happens, we need a O(n2) time to update the sum.

  * As the problem mentioned, "the number of calls to update and sumRange function is distributed evenly", which indicates the operations of update and sum occur frequently, and we cannot first store the sum with the hope that update calls are rare.

  * If it is not specially pointed out, we need to improve the performance of both sum and update calls. Changing the time to O(1) is unrealistic, so we think about trying to change O(n) to O(logn). This is usually a binary tree searching time. Therefore we know that we need to do pre-processing utilizing the binary tree structure.

* For such a problem as using tree structure and searching certain statistics in an interval, it's very appropriate to use Segment Tree. Its idea is that, we first store the whole interval into a root node of the tree, and then constantly binarize the interval and stored them into left and right subtrees.

* The beauty of segment tree method is that for each step (Building tree, updating tree and taking sum), we all can use similar set of divide and conquer helper functions. The leaf node has start and end boundary equal.


### Code
```Java
class NumArray {

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = new SegmentTreeNode(0, 0);

    public NumArray(int[] nums) {
        root = initializeTree(nums, 0, nums.length - 1);
    }
    private SegmentTreeNode initializeTree(int[] nums, int start, int end) {
        if(start > end) {
            return new SegmentTreeNode(0, 0);
        }
        SegmentTreeNode res = new SegmentTreeNode(start, end);

        if(start == end) {
            res.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            res.left = initializeTree(nums, start, mid);
            res.right = initializeTree(nums, mid + 1, end);
            res.sum = res.left.sum + res.right.sum;
        }

        return res;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }
    private void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
           root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
         return sumRange(root, i, j);
    }
    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(root.right, start, end);
            }  else {    
                return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
```
# Summary
* Divide conquer technique is used a lot in binary tree traversal and update.
* I learned a useful tree algorithm, which can solve a kind of problem: search an interval for certain statistics (minimum, max or sum).
