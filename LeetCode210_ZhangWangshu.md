# LeetCode210
* 作者：张望舒
* 版本：2018-02-27

# 题目描述Course Schedule II

# 思路报告
1. Intuitively想，把所有课程遵循先后顺序都上完，那肯定先修没有prerequisites的课。等所有这些课都上完之后，再update一下课程的prerequisite情况，接着从没有prerequisites的课上起。如果可能之间的先后逻辑没有问题的话（出现A是B prerequisite, B也是A prerequisite），那么最终所有的课都会上完。 Course Schedule那道题问的就是是否最后所有的课都能上完。
2. 这个问题最适合的数据结构就是有向图。每一个课程是图上的一个node，prerequisite课程指向后序课程。所以这个题就抽象成为了图上的拓扑排序问题。
3. 首先初始化将图存起来，并且建立一个数组存每个节点的入度。入度为0的点就是最先要被加到结果数组里的点，我们用一个Queue来存起来。之后遍历这些入度为0的点的每一个邻接点，同时把更新入度后入度为0的邻接点再放入队列，不断循环直到队列为空。
4. 最后别忘了有可能无法排序成功的情况，因为题里说：If it is impossible to finish all courses, return an empty array. 所以用一个count计数来判断排序是否成功。

### 代码

```Java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        List<Integer>[] map = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<>();
        }
    /*
        for(int i = 0; i < numCourses; i++) {
            map[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }*/
        for (int[] path : prerequisites) {
            map[path[1]].add(path[0]);
            ++indegree[path[0]];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int head = q.poll();
            result[count] = head;
            for(int node:map[head]) {
                indegree[node]--;
                if(indegree[node] == 0) {
                    q.offer(node);
                }
            }
            count++;
        }
        if(count != numCourses) {
            return new int[0];
        }
        return result;
    }
}
```


# 套路总结

* 这道题因为课程给了编号，而且都是连续的整数，所以我们可以用一个二维ArrayList来存这些课。但是以前我不熟悉二维ArrayList怎么初始化和遍历，主要的错误都处在这里。所以还是要熟悉一下List/Map/Set的用法，因为肯定在图的问题上会经常用到。这道题如果课程不是连续的整数的话，可能就要用HashMap<Set<Integer>>。这样写起来就麻烦一点了。
