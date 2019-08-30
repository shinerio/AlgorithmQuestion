public class 矩阵中的路径 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (rows == 0 || cols == 0) {
            return false;
        }
        boolean[][] mark = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(mark, matrix, rows, cols, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath(boolean[][] mark, char[] matrix, int rows, int cols, char[] str, int startR, int startC, int cur) {
        if (cur == str.length) {
            return true;
        }
        if (startR >= rows || startC >= cols || startR < 0 || startC < 0 || mark[startR][startC] || matrix[startR*cols + startC] != str[cur]) {
            return false;
        }
        mark[startR][startC] = true;
        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int[] d : dir) {
            if (hasPath(mark, matrix, rows, cols, str, startR+d[0], startC+d[1], cur+1)) {
                return true;
            }
        }
        mark[startR][startC] = false;
        return false;
    }
}
