# LeetCode496

* Author：Wangshu Zhang
* Version：2020-03-22

# Problem: Next Greater Element I

### Code
```Java
// My own solution
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length - 1; i ++) {
            for (int j = i + 1; j < nums2.length; j ++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
            map.putIfAbsent(nums2[i], -1);
        }
        map.put(nums2[nums2.length - 1], -1);
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

// Stack Solution
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i --) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
```
