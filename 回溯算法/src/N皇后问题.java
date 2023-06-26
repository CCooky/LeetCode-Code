import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1 <= n <= 9
 */
public class N皇后问题 {
}

class Solution14 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];//棋盘初始化为 . ;
        for (char[] chars : chessboard) {
            Arrays.fill(chars,'.');
        }
        List<List<String>> validChessboardList = new ArrayList<>();
        int index = 0;
        backTracking(chessboard,n, validChessboardList,index);
        return validChessboardList;

    }

    // 棋盘问题——回溯暴力，行就是树层、树枝的每次选取都是从0开始
    // 1.参数: 存放单个递归得到的棋盘-使用集合？不行我们要一行行递归一列列递归，要用数组char[][]
    // 然后 n插进来，二维数组的长宽；然后来一个结果集合-List<List<String>>
    // 最后需要一个index-代表当前搜索的行，来切换我每次选取元素的数据集，这和“电话号码的字母组合”是一个意思，因为是从不同的集合里面寻找配对的
    public void backTracking(char[][] chessboard, int n, List<List<String>> validChessboardList, int index) {
        //2.终止条件（因为在回溯搜索过程中，已经做了判断所以这里直接添加
        if (index == n) {
            //将二维数组按照格式转换成 [".Q..","...Q","Q...","..Q."]
            List<String> leafChess = new ArrayList<>();
            for (char[] chars : chessboard) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < chessboard.length; j++) {
                    stringBuilder.append(chars[j]);
                }
                leafChess.add(stringBuilder.toString());
            }
            // 将合法棋盘放到结果集
            validChessboardList.add(leafChess); //检查new
        }

        //3.回溯搜索：（前面要加一个判断合法性，不合法就continue）+处理、递归、回溯
        for (int i = 0; i < n; i++) { // i 代表列
            if (!isValid(chessboard, index, i, n)) {  // 如果某个非叶子节点不合法，就会停止向下搜索，直接回溯到上一个节点（上一个树层），开始下一个for横向遍历
                continue;
            }
            //
            chessboard[index][i] = 'Q';
            //
            backTracking(chessboard, n, validChessboardList, index + 1);
            //
            chessboard[index][i] = '.';
        }
    }

    // 判断当前位置是不是满足要求
    //不能同行
    //不能同列
    //不能同斜线 （45度和135度角）
    private boolean isValid(char[][] chessboard, int row, int column, int n) {
        //同行, 好像不会同行哦，因为每行都是一个树层，是一层层往下的，每行选一个位置
        //同列
        for (int j = 0; j < n; j++) {
            if (chessboard[j][column] == 'Q') {
                return false;
            }
        }
        //同斜角(这里只用往右上角、左上角判断，因为元素是一层层选取，下面还没有元素呢）
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
