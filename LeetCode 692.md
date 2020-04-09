# LeetCode692

* Author：Wangshu Zhang
* Version：2020-04-08

# Problem: Top K Frequent Words

# References about implementing comparator:
https://www.geeksforgeeks.org/collections-sort-java-examples/
https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/
https://www.geeksforgeeks.org/priorityqueue-comparator-method-in-java/
https://howtodoinjava.com/java/collections/java-comparable-interface/
https://forum.processing.org/two/discussion/10244/priorityqueue-and-comparable-interface-example

### Code
```Java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        class MyComparator implements Comparator<String> {
            public int compare(String a, String b) {
                if (map.get(a) == map.get(b)) {
                    return a.compareTo(b);
                } else {
                    return map.get(b) - map.get(a);
                }
            }
        }

        List<String> candidates = new ArrayList(map.keySet());
        Collections.sort(candidates, new MyComparator());
        return candidates.subList(0, k);   
    }
}
```
