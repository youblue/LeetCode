# LeetCode322
* 作者：张望舒
* 版本：2018-03-08

# 题目描述Coin Change

# 思路报告
1. 首先类比CombinationSum，用DFS来做。基本思想就是从amount开始，不停扣除硬币数直到为0，就算找到了一个解。那么题目的要求实际上就是统计得到每一个解的helper function的调用次数，求可能的一组helper function递归次数最少的解。这里面因为用了memory search方法，所以新建了一个count数组来记录amount从0到amount时候的最少硬币数，这样就不用重复计算了。
2. 然后我又用了DP方法来解决。这里DP的思路比较好想，因为大问题就是一个定义好了的最优化问题，而子问题也非常显而易见的是一个小的最优问题：count数组每一个元素就是达到certain amount时候用的最小硬币的个数。显而易见count[0] = 0。迭代公式是min = Math.min(min, count[i-coins[j]] + 1)，min是全局最小值。针对一个amount，把所有coin遍历完就将min赋值给count[i]。

### 代码

```Java
// Memory Search
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int[] count = new int[amount + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        return helper(coins, amount, count);
    }
    private int helper(int[] coins, int amount, int[] count) {
        if(count[amount] != Integer.MAX_VALUE) {
            return count[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) {
                int res = helper(coins, amount - coins[i], count) + 1;
                if(res != 0) {
                    min = Math.min(min, res);
                }   
            }
        }
        count[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return count[amount];
    }
}
```


```JAVA
// DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count, -1);
        count[0] = 0;
        for(int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j] && count[i-coins[j]] != -1) {
                    min = Math.min(min, count[i-coins[j]] + 1);
                    count[i] = min;
                }
            }
        }
        return count[amount];
    }
}
```



# 套路总结

* 深深理解了萌萌老师说的Permutation/Subsets/CombinationSum/Coin Change等题目都是一道题，都是主要在helper function里for loop进行DFS，然后如果有重复计算的情形就要考虑剪枝。
* DP算法的关键就是首先得到大问题的定义，然后成功找到最优子问题的定义。换言之，就是归纳法的迭代公式。另外要特别注意设置好边界/初始化条件，这个是最容易出错的地方。
