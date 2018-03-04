
# LeetCode332
* 作者：张望舒
* 版本：2018-03-04

# 题目描述Reconstruct Itinerary

### Test Case 1
Input: [["JFK","ATL"],["ATL","JFK"]]

Output: ["JFK","ATL","JFK",null]

Expected: ["JFK","ATL","JFK"]

### Test Case 2
Input: [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]

Output: ["JFK","KUL"]

Expected: ["JFK","NRT","JFK","KUL"]


### 代码

```Java
// Mine


```








```Java
// Solution by Advisor
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for(int i = 0; i < tickets.length; i++) {
            if(!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new PriorityQueue<String>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        String cur = "JFK";
        dfs(cur, map, result);
        return result;
    }
    private void dfs(String cur, Map<String, PriorityQueue<String>> map, LinkedList<String> result) {
        while(map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map.get(cur).poll(), map, result);
        }
        result.addFirst(cur);
    }
}
```
