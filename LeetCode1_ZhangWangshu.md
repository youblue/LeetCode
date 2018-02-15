# LeetCode1
* 作者：张望舒
* 版本：2018-02-12

# 题⽬描述Two Sum
* Return indices of two!

# 思路报告
1.  先问清楚时间复杂度和空间复杂度有没有要求？

    i. 如果要求in place，那用两个for loop iterate each pair of elements，时间复杂度O（n^2）。

    ii. 如果空间复杂度没要求，我会最先想到用Hash，因为遍历一遍数组会把所有值的相关信息都存起来，之后的编程会更简单方便，时间复杂度O(n)。

2. 在没太看清返回值要求的情况下第一反应是HashSet。从左到右读每一个element，如果Set里有Target-element，那就代表“找到了”，否则把这个element存在Set里，以备后面element寻找。

3. 程序写一半的时候比较傻眼：看到要返回“找到了”的pair的position, 这个我的HashSet并没存！
    * 所以修改HashSet为HashMap<Integer, Integer>，KEY存element value, VALUE存element position。

### 代码

```cpp
// C++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        map<int, int> key_pos;
        if(nums.size() < 2) {
            return result;
        }
        for(int i = 0; i < nums.size(); i++) {
            map<int, int>::iterator iter = key_pos.begin();
            iter = key_pos.find(target - nums[i]);
            if(iter == key_pos.end()) { // Not found
                key_pos[nums[i]] = i;
            } else { // Found
                result.push_back(iter->second);
                result.push_back(i);
                return result;
            }
        }
        return result;
    }
};
```

```Java
// Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
```


# 套路总结

* 一定注意审题，看准题目输入和输出要求。
* HashMap／HashSet经常在能保证时间复杂度O(N)的情况使用，想到了用Hash不要急于去做，一定要先想清楚具体怎么用、里面存什么。
* JAVA的HashMap语法不是很熟练，需要练习。
