import java.util.HashSet;
import java.util.Set;

public class 实现前缀树062 {


}

class Trie {

    private Trie[] children;
    private boolean isWord;

    public void insert(String s) {
        Trie node = this; // 跟节点（不存放数据）
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index]; // 移动到当前字符的节点
        }
        node.isWord = true;
    }

    public boolean search(String s) {
        Trie node = this;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) { // 路径找不到
                return false;
            }
            node = node.children[index];
        }
        return node.isWord; // 找到了路径，还要判断是否存储了者条路径！！！
    }

    public boolean startsWith(String prefix) { // 和前面的是一模一样
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) { // 路径找不到
                return false;
            }
            node = node.children[index];
        }
        return true; // 找到了路径就可以了
    }

    public Trie() {
        children = new Trie[26];
        isWord = false;
    }
}
