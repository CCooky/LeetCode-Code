import java.util.ArrayList;
import java.util.List;

public class 最少回文分割 {


    public int minCut(String s){
        // 先得到所有的分割方案，然后每种方案的分割次数就是其 长度-1
        List<List<String>> partition = partition(s);
        int min = 0;
        for (List<String> list : partition) {
            min = Math.min(list.size()-1, min);
        }
        return min;
    }

    public  List<List<String>> partition(String s) {
        backTracking(s,0);
        System.out.println(pathList);
        return pathList;

    }

    // 分割线-startIndex；此次分割出来的子串【start Index，i】
    List<String> path = new ArrayList<>();
    List<List<String>> pathList = new ArrayList<>();
    public  void backTracking(String s, int startIndex) {
        // stop
        if (startIndex == s.length()) {
            pathList.add(new ArrayList<>(path));
            return;
        }
        //3.
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (!isPalinDrome(sub)) {
                continue;
            }
            //
            path.add(sub);
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }

    }

    private  boolean isPalinDrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
