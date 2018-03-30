# LeetCode323
* Author：Wangshu Zhang
* Version：2018-03-27

# Problem: Number of Connected Components in an Undirected Graph

# Thoughts
* This is a typical graph traversal problem to find the number of connected components. I feel some similarities between the concepts of "Connected components" and "Island", and soon think about another problem "Number of Island".

* For the "Number of Island" problem, we can use DFS to traverse the matrix, while "Dye" the visited element in the matrix from "1" to "0". The number of islands is calculated by how many time we started from a new "1".

* Similarly, for this problem, also starting from a node, and we DFS all it's neighbors until all are visited. When a neighbor is visited, we remove it from the neighboring list of current node (to avoid circular re-visiting in the future), and all the nodes visited are also flagged as "true" in a boolean array isVisited. Whenever a round of DFS is started from a non-singleton node, the count of connected components increase 1. There's could be a case that many singletons are left after we finish traversing all connected components, so I use a forloop to check if there's un-vistied singleton, and increase the count by 1 for each of such node.

* Another thing need to think about is how to store the graph. The input is a two-dimensional array storing edges, and from the problem description we know that there are "n nodes labeled from 0 to n - 1". So here I reused the data structure in the "Course Scheduler" problem, as follows:

      List<Integer>[] graph = new ArrayList[n];
Compared to HashMap, it's more space and time efficient.


### Code
```Java
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
# Summary
* For graph structure the graph is either stored as HashMap or List of ArrayList. If the node value is just integer, the latter way is more efficient.
* Reuse of the learned code piece from other problems is really helpful.
