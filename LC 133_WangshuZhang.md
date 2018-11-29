# Leetcode 133. Clone Graph
@Author: Wangshu Zhang

# Thoughts
* Cloning a graph include cloning the vertex and cloning the edges. These two cloning are better done in one pass. In order to using the original graph as "blueprint" to clone new graph, we need a HashMap to record the pair of corresponding nodes in two graphs.We use a DFS method to traverse the graph, and during the traversal update the Hashmap (which can also serve as a isVisited flag of the nodes).

### Code

```Java
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// This is a BFS solution
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode>map = new HashMap<>();
        UndirectedGraphNode node2 = new UndirectedGraphNode(node.label);
        map.put(node, node2);

        // traverse while: (1) cloning node if new node is not in map yet (2) add edges
        Deque<UndirectedGraphNode> q = new ArrayDeque<>();
        q.addLast(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode nd1 = q.removeFirst();
            UndirectedGraphNode nd2 = map.get(nd1);

            for (UndirectedGraphNode nei1 : nd1.neighbors) {
                if(map.containsKey(nei1)) {
                    nd2.neighbors.add(map.get(nei1));
                } else {
                    q.add(nei1);
                    UndirectedGraphNode nei2 = new UndirectedGraphNode(nei1.label);
                    map.put(nei1, nei2);
                    nd2.neighbors.add(nei2);
                }
            }
        }
        return map.get(node);
    }
}
```


```Java
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        helper(node, map);
        return map.get(node);
    }
    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode node2 = new UndirectedGraphNode(node.label);
        map.put(node, node2);
        for (UndirectedGraphNode nei : node.neighbors) {
            node2.neighbors.add(helper(nei, map));
        }
        return node2;
    }
}
```

# Summary
* The graph cloning needs traverse the graph, here we use a DFS method, so that needs a helper function.
