# Leetcode 332. Reconstruct Itinerary
@Author: Wangshu Zhang

# Thoughts
* The idea of this problem is still using DFS, but needs to pay attention that the problem requires that when multiple solutions exist, cities in smaller alphabetical order should come first. Therefore, we use a Map<String, PriorityQueue<String>> data structure to store all cities in to a graph, and then implement dfs on this graph.

### Code
```Java
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new PriorityQueue<String>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        String start = "JFK";
        dfs(start, map, res);
        return res;
    }
    private void dfs(String cur, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        /*
        if (!map.containsKey(cur) || map.get(cur).isEmpty()) {
            return;
        }
        dfs(map.get(cur).poll(), map, res);
        res.addFirst(cur);
        */
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map.get(cur).poll(), map, res);
        }
        res.addFirst(cur);
    }
}
```

# Summary
* One part that needs to pay attention is that in the dfs function, we need a while loop to recursive call dfs of all mapped city in the PriorityQueue. If we use the "if" clause, we will miss the last city.
