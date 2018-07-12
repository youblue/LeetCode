# Leetcode 208. Implement Trie (Prefix Tree)
@Author: Wangshu Zhang

# Thoughts
* Trie is a kind of tree, so before initializing tree, we need a "node" class, like defining "TreeNode" in the binary tree related problems.

### Code
```Java
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode node = this.root;
        char[] letters = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            } else {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0; i < prefix.length(); i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    // Initialize your data structure here.
    int num;// 有多少单词通过这个节点,即节点字符出现的次数
    TrieNode[] son;// 所有的儿子节点
    boolean isEnd;// 是不是最后一个节点
    char val;// 节点的值

    TrieNode() {
        this.num = 1;
        this.son = new TrieNode[26];
        this.isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```



# Summary
* Have no idea about the utility of Trie tree until reading the solution article of leetcode.
