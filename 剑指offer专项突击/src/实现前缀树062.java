import java.util.HashSet;
import java.util.Set;

public class 实现前缀树062 {


}

class Trie {

    private Set<String> allElement;
    private Set<String> allPrefix;

    public void insert(String s) {
        allElement.add(s);
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i + 1);
            allPrefix.add(s1);
        }
    }

    public boolean search(String s) {
        if (allElement.contains(s)) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (allPrefix.contains(prefix)){
            return true;
        }
        return false;
    }

    public Trie() {
        this.allElement = new HashSet<>();
        this.allPrefix = new HashSet<>();
    }

}
