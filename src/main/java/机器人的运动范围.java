import java.util.stream.Stream;

public class 机器人的运动范围 {
    boolean[][] mark ;
    public static void main(String[] args) {

        new 机器人的运动范围().movingCount(5,10,10);
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        mark = new boolean[rows][cols];
        search(threshold,0, 0, rows, cols);
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += mark[i][j] ? 1 : 0;
            }
        }
        return sum;
    }

    public void search(int threshold, int x, int y, int rows, int cols) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || mark[x][y] == true || sumDigits(x, y) > threshold) {
            return;
        }
        mark[x][y] = true;
        int[][] next = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int [] n : next) {
            search(threshold, x+n[0],y+n[1], rows, cols);
        }
    }

    public int sumDigits(int x, int y) {
        int sum = 0;
        while (x !=0 || y!=0 ){
            sum = sum + (x%10) + (y%10);
            x /= 10;
            y /= 10;
        }
        return sum;
    }
}
