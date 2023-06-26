public class 二维数组中的查找 {
    public static void main(String[] args) {
//        int[][] nums = new int[][]{
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}
//        };
        int[][] nums = new int[][]{
                {3,3,8,13,13,18},
                {4,5,11,13,18,20},
                {9,9,14,15,23,23},
                {13,18,22,22,25,27},
                {18,22,23,28,30,33},
                {21,25,28,30,35,35},
                {24,25,33,36,37,40}
        };
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findNumberIn2DArray(nums,21));
    }
}

class Solution2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        if (matrix[0].length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        //每一行是非递减的，可以使用二分去做，半暴力
        for (int i = 0; i < row; i++) {
            //这里是二分法的实现，我草，差一点写错了还
            int left = 0;
            int right = col-1;
            int mid = (left+right)/2;
            while (left<=right){
                if (matrix[i][mid]==target){
                    return true;
                }else if(target>matrix[i][mid]){
                    left = mid+1;
                    mid = (left+right)/2;
                }else {
                    right = mid-1;
                    mid = (left+right)/2;
                }
            }
        }
        return false;
    }


}
