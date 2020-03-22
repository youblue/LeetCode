# LeetCode169

* Author：Wangshu Zhang
* Version：2020-03-05

# Problem: Majority Element

# Thoughts
https://www.youtube.com/watch?v=CUjElzZXfYA
https://leetcode.com/problems/majority-element/solution/

### Code
```Java
// HashMap method
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.putIfAbsent(x, 0);
            if ((map.get(x) + 1) * 2 >= nums.length) {
                return x;
            }
            map.put(x, map.get(x) + 1);
        }
        return nums[0];
    }
}
```

```Java
// "Beat and Keep Winner" method (拼杀法)
class Solution {
    public int majorityElement(int[] nums) {
        int winner = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == winner) {
                count ++;
            } else if (count == 0) {
                winner = nums[i];
                count ++;
            } else {
                count --;
            }
        }
        return winner;
    }
}

// Similarly, Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int x : nums) {
            if (count == 0) {
                candidate = x;
            }
            count += (x == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

```

```Java
// Sort method
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
```


# Summary
Solve it is easy, but really hard to figure it out with fastest time and reasonable space complexity!
