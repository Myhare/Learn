package 算法练习.力扣练习.前缀树;

// 前缀树
public class Trie {

    public Trie[] children;
    public boolean isEnd;

    // 构造方法
    public Trie() {
        // 最多26个子节点 26个英文字母
        this.children = new Trie[26];
        this.isEnd = false;
    }

    // 向前缀树插入一个字符串
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // 搜索前缀树中有没有word一整个单词
    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    // 搜索前缀树中有没有一部分是prefix
    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        return trie != null;
    }

    /**
     * 搜多当前前缀在前缀树中的最后一个节点，如果没有返回null
     */
    private Trie searchPrefix(String prefix){
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
