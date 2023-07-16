public class 最多删除一个字符得到回文019 {

    public boolean getRes(String s) {
        // 就是删或者不删呗，暴力
        if (isPalindrome(s)) {
            return true;
        }
        //删除哪一个呢，双指针从头尾开始,遇到不同字符暂停， 可以试着删除其中一个字符,再判断中间部分回文
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) { //找到第一个不相等的判断就可以了，时间复杂度很低哦
                //删除left
                String leftString = s.substring(left + 1, right + 1); // [left+1, right]
                if (isPalindrome(leftString)) {
                    return true;
                }
                //删除right
                String rightString = s.substring(left, right);
                if (isPalindrome(rightString)) {
                    return true;
                }
                // 如果前面两个删除方法都不是回文，则整体结果就false
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
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
