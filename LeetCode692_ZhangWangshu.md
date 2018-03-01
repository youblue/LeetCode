# LeetCode692
* 作者：张望舒
* 版本：2018-02-27

# 题目描述Top K Frequent Words

# 思路报告
1. 题目说Try to solve it in O(n log k) time and O(n) extra space。由O(n) extra space想到了用一个HashMap来存所有的word和其对应的词频关系。然后又由选出top K这一点想到可以建一个size为K的heap。对于每一个元素进堆比较一次，最多是logK的时间，所以时间最多O(n log K)。
2. 将word全存进HashMap比较好些，这里我学到了一个高级的写法：map.put(word, map.getOrDefault(word, 0) + 1)。
3. 比较难的就是怎么写PriorityQueue的comparator参数。这个部分参考了Qinyuan老师的写法，个人感觉用Lambda函数的写法简单很多。
4. 最后输出结果的时候我最开始采用倒序加入result，这样顺序就不会错了。但是这样可能很费时间复杂度，所以先将反向的结果输出然后用Collections的reverse方法reverse。

### 代码

```Java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(String word:words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> q = new PriorityQueue<>(
            (a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b)
        );
        for(String word:map.keySet()) {
            q.offer(word);
            if(q.size() > k) {
                q.poll();
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            //result.add(0, q.poll());
            result.add(q.poll());
            count++;
        }
        // reverse
        Collections.reverse(result);

        return result;
    }
}
```


# 套路总结

* 在NLog(K)的时间内选择TopK的问题，想到用Heap来解决。
* 还需要熟练PriorityQueue里Comparator的写法。
* PriorityQueue弹出的时候结果是倒序的，需要reverse。 
