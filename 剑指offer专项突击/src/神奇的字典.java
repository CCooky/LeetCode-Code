import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 神奇的字典 {
}

class MagicDictionary {

    private Map<String, Integer> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            map.put(s, s.length());
        }
    }

    public boolean search(String searchWord) {
        int n = searchWord.length();
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() == n) {
                // compare
                String key = entry.getKey();
                int p = 0;
                int count = 0;
                while (p < n) {
                    if (searchWord.charAt(p) != key.charAt(p)){
                        count++;
                    }
                    p++;
                }
                if (count==1) return true;
            }
        }
        return false;
    }
}
