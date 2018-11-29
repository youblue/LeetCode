# Leetcode 207. Course Schedule
@Author: Wangshu Zhang
@Date: Nov 23, 2018

# Thoughts
* Topological sort, detect if there exists a circle.
* Two ways: BFS and DFS, BFS easier to think for me, but I need to familiar with the DFS way as well.

### Code

```Java
// BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] indegree = new int[numCourses];
        for (int[] courses : prerequisites) {
            graph[courses[1]].add(courses[0]);
            indegree[courses[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            numCourses--;
            for (int j : graph[cur]) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return numCourses == 0;
    }
}
```


```Java
// DFS

```

# Summary
* One difficulty is what data structure to select for storing the graph.
