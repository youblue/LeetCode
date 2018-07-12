# Leetcode 475. Heaters
@Author: Wangshu Zhang

# Thoughts
* I have tried brute force versions but unfortunately encountered "Time Limit Exceed".
* By searching the answer online I learned the binary search version.


### Code
```Java
// Brute Force version 1: Time Limit Exceed
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || heaters == null || houses.length == 0 || heaters.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int cur = Math.abs(houses[i] - heaters[0]);
            for (int j = 1; j < heaters.length; j++) {
                cur = Math.min(cur, Math.abs(houses[i] - heaters[j]));
            }
            if (cur > res) {
                res = cur;
            }
        }
        return res;
    }
}
```


```Java
// Brute Force version 2: Time Limit Exceed
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || heaters == null || houses.length == 0 || heaters.length == 0) {
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int cur = Math.abs(houses[i] - heaters[0]);
            int j = 0;
            while (j < heaters.length -1 && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
        }
        return res;
    }
}
```


```Java
// Binary search version
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
		int result = 0;
		for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);
			if (index < 0) { // index<0,则说明在heaters中没有该house,返回 (-(插入点) - 1),第一个大于此键的元素索引  
				index = ~index; // Or use: index = -(index + 1);
				int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
	            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                result = Math.max(result, Math.min(dist1, dist2));
			}
			//index>=0,则说明在headers中找到了该house, 则说明取暖器位置和house位置重合，该house的最小半径为0,result不变
		}
		return result;
    }
}
```


# Summary
* It's more time-saving to use Arrays.binarySearch instead of writing by oneself.
