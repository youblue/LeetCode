# Leetcode 11. Container With Most Water
@Author: Wangshu Zhang

# Thoughts
* This problem does not provide an example, so I am very confused about how the water volume is defined. Then I make sure that it means the water contained is calculated as:

    Min (left height, right height) * (right - left)
* There's a trick that we can use double pointer method: move the pointer with the lower height, and we won't miss any possible solution. Because only by moving the lower height pointer we can possibly find a container with larger volume.


### Code
```Java
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
```


```Python
class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if height == []:
            return 0
        left = 0
        right = len(height) - 1
        res = 0
        while left < right:
            res = max(res, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1;
            else:
                right -=1;
        return res
```



# Summary
* The time complexity is O(n). Think more about the feasibility of the double pointer solution.
