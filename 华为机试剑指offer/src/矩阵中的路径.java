public class 矩阵中的路径 {
}
class Solution6 {
    public boolean exist(char[][] board, String word) {
        //矩阵搜索路径类型，每个点可以上下左右搜索。采用两个for去暴力搜索
        // dfs的返回值意义是：被匹配的字符串在矩阵种有相同路径；
        int m = board.length;
        int n = board[0].length;
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean dfs = dfs(board, i, j, word, index);
                if (dfs) return true; //有一个为true即可
            }
        }
        //
        return false;
    }

    //index 表示当前匹配的字符索引
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        //如果i、j越界了return false；如果当前字符和矩阵i，j字符不匹配 return false
        if (i<0||i>board.length-1 || j<0||j>board[0].length-1
        || word.charAt(index)!=board[i][j]){
            return false;
        }
        //如果全部匹配上，返回true
        if (index == word.length()-1){
            return true;
        }
        //处理、递归、回溯;
        char temp = board[i][j];
        board[i][j] = '.'; //防止重复匹配
        boolean res = dfs(board, i+1, j, word, index+1)
                || dfs(board, i-1, j, word, index+1)
                || dfs(board, i, j+1, word, index+1)
                || dfs(board, i, j-1, word, index+1);
        board[i][j] = temp;
        return res;

    }
}
