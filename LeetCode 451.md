# LeetCode451

* Author：Wangshu Zhang
* Version：2020-02-24

# Problem: Sort Characters By Frequency

# Thoughts
* The first idea naturally comes into my mind is using HashMap to record character-frequency relationships. Then output from the highest frequency. To fulfill this, we also need a frequency-character map.
* So my solution is, first reading the string once and build the character-frequency map. Then read the map and build a adjacent list data structure (each key is frequency, and a list of characters linked to each key). Therefore we can output from highest key of this adjacent list.
* I have once tried to use bucket sort instead of Map<Integer, Set\<Character\> > for the adjacent list, but don't know how to write it. I attach another solution from leetcode discussion board.


### Code
```Java
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Integer, Set<Character> > map_set = new TreeMap<>();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char c = m.getKey();
            int count = m.getValue();
            Set<Character> set = new HashSet<>();
            if (map_set.containsKey(count)) {
                set = map_set.get(count);
            }
            set.add(c);
            map_set.put(count, set);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : map_set.keySet()) {
            Set<Character> set = map_set.get(i);
            for (Character c : set) {
                for (int j = 0; j < i; j ++) {
                    sb.append(c);
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
```

```Java
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < map.get(c); i++)
                        sb.append(c);

        return sb.toString();
    }
}
```



# Summary
* Familiar with Java grammar and see if there's easier way. Also to get a map with key in order, don't forget to use TreeMap instead of HashMap.
