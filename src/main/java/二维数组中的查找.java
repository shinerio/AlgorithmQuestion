/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中
 */
public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int startX = array[0].length - 1;
        int startY = 0;
        while (startX >= 0 && startY < array.length){
            if (array[startY][startX] == target) {
                return true;
            }
            if (array[startY][startX] > target) {
                startX--;
            } else {
                startY++;
            }
        }
        return false;
    }
}
