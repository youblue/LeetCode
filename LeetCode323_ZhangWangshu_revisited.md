# LeetCode323
* Author：Wangshu Zhang
* Version：2018-03-29

# Problem: Number of Connected Components in an Undirected Graph

# Thoughts
* Last time I only wrote the DFS solution. This time I provide all three solutions.
* In the BFS solution, I construct a queue to store nodes to be visited, and also use a boolean array to flag visited nodes. Here in BFS, if a node is visited, it will not be added to the queue again. So whenever a round of BFS is run, the count of connected components increase by 1. Then we can get the final count.
* The Union Find solution is almost all from temmplate.

### Code
```Java
// DFS
class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n == 0 || edges == null) {
            return 0;
        }
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int count = 0;
        boolean[] isVisited = new boolean[n];
        Arrays.fill(isVisited, false);

        for(int i = 0; i < n; i++) {
            if(graph[i].size() == 0) {
                continue;
            }
            if(graph[i].size() != 0 && !isVisited[i]) {
                count++;
                isVisited[i] = true;
                dfs(graph, i, isVisited);
            }
        }
        for(int i = 0; i < isVisited.length; i++) {
            if(!isVisited[i]) {
                count += 1;
            }
        }
        return count;
    }
    private void dfs(List<Integer>[] graph, int i, boolean[] isVisited) {
        if(graph[i].size() == 0) {
            return;
        }
        List<Integer> temp = new ArrayList<>(graph[i]);
        for(int j : temp) {
            if(isVisited[j]) {
                continue;
            }
            isVisited[j] = true;
            graph[i].remove(new Integer(j));
            if(isVisited[j])
            dfs(graph, j, isVisited);
        }
    }
}
```

```Java
// BFS
class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n == 0 || edges == null) {
            return 0;
        }
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int count = 0;
        boolean[] isVisited = new boolean[n];
        Arrays.fill(isVisited, false);

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(isVisited[i]) {
                continue;
            }
            q.offer(i);
            count++;
            bfs(graph, q, isVisited);
        }
        return count;
    }
    private void bfs(List<Integer>[] graph, Deque<Integer> q, boolean[] isVisited) {
        while(!q.isEmpty()) {
            int i = q.poll();
            isVisited[i] = true;
            for(int j : graph[i]) {
                if(!isVisited[j]) {
                    q.offer(j);
                }
            }
        }
    }
}
```

```Java
// Union Find
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges){
            int parent1 = findParent(edge[0], parent);
            int parent2 = findParent(edge[1], parent);
            //Union
            if(parent1 != parent2) {
                parent[parent1] = parent2;
            }
        }
        //Count components
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) {
                count++;
            }
        }
        return count;
    }
    private int findParent(int i, int[] parent) {
        while(i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
```


# Summary
* It's very useful to practice all the 3 typical solutions, I feel the codes here can serve as template for many similar problems.
* Preferences of BFS and DFS for different purposes: to find if there's a circle in a graph I prefer using DFS, and to find number of connected components I prefer BFS.
* I newly learned the Union Find algorithm, which is really simple but magic.
