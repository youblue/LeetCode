# Leetcode 787. Cheapest Flights Within K Stops
@Author: Wangshu Zhang

# Thoughts
* In graph theory, the Bellman–Ford algorithm is an algorithm that computes shortest paths from a single source vertex to all of the other vertices in a weighted digraph. Here I utilized this algorithm to expand the graph from the source node "K+1" times, because in this problem K=0 means jump 1 step, and K=K means jump K+1 times. At each iteration we record for each node the cost from source, and finally check the cost of destination node.

### Code
```Java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prev_dp = new int[n];
        int[] cur_dp = new int[n];
        Arrays.fill(prev_dp, Integer.MAX_VALUE);
        Arrays.fill(cur_dp, Integer.MAX_VALUE);
        prev_dp[src] = 0;

        for (int k = 0; k <= K; k++) {
            for (int[] arr : flights) {
                if (prev_dp[arr[0]] < Integer.MAX_VALUE) {
                    cur_dp[arr[1]] = Math.min(cur_dp[arr[1]], prev_dp[arr[0]] + arr[2]);
                }
            }
            System.arraycopy(cur_dp, 0, prev_dp, 0, n);
        }
        return cur_dp[dst] == Integer.MAX_VALUE ? -1 : cur_dp[dst];
    }
}
```

# Summary
* The algorithm itself utilizes the idea of dynamic programming. I think the other solutions (DFS + memorized search, priorityQueue method) are not as simple as this.
