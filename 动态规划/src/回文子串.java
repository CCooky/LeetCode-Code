public class 回文子串 {
}

class Solution1111 {
    public int countSubstrings(String s) {
        //1.dp数组含义、大小
        //dp[i][j]：表示索引区间在【i，j】的子串是不是回文子串，是的话则为false；
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; //索引最大是n-1

        //3.dp数组初始化
        //根据递推公式，dp[i][j]可以由左下角推出，这也不能直接得到信息啊，除了斜线，但斜线也可以由递推公式得到
        //所以全部给false先
        //2.递推公式（i<=j)
        //  索引i处等于索引j处：三种情况；
        //  1.i==j,true; j-i=1,true;  j-i>=2, kan dp[i+1][j-1]
        // 不等于就简单，只有一种情况
        //4.遍历顺序，dp[i][j]可以由左下角推出，所以我们要先遍历左下角.并且j>=i，所以最后dp数组我们只管了右上角的部分！！
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[0].length; j++) { //j>=i
                if (s.charAt(i) == s.charAt(j)) {
                    //3个情况
                    if (i == j) dp[i][j] = true;
                    if (j - i == 1) dp[i][j] = true;
                    if (j - i > 1) dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        //最后的结果在哪里,要去遍历dp数组，并且i<=j。也可以直接在上面的for记录
        int num = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                if (dp[i][j] == true) {
                    num++;
                }
            }
        }
        return num;
    }

    public int countSubstrings2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //一个元素可以作为中心点，两个元素也可以作为中心点。
            //三个元素就可以由一个元素左右添加元素得到，四个元素则可以由两个元素左右添加元素得到
            result = result + extend(s, i, i, s.length());
            result = result + extend(s, i, i+1, s.length());
        }
        return result;

    }

    // i:中心回文串的开始索引，j：中心的结束索引
    public int extend(String s, int i, int j, int n) {
        int num = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            num++;
            i--; //中心往两边扩散，已经保证了中间是回文串
            j++;
        }
        return num;
    }
}
