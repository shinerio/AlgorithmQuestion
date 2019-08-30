import java.util.Arrays;

public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        System.out.println(new 旋转数组的最小数字().minNumberInRotateArray(new int[]{ 2, 3, 4,0,1}));
    }
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return minNumberInRotateArray(array, 0, array.length-1);
    }

    public int minNumberInRotateArray(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        int m = left + (right - left)/2;
        if (array[m] < array[right]) {
            return minNumberInRotateArray(array, left, m);
        } else if (array[m] > array[right]) {
            return minNumberInRotateArray(array, m+1, right);
        } else {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    return array[i + 1];
                }
            }
            return array[right];
        }
    }

}
