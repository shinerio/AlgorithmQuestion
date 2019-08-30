import java.util.stream.Stream;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class 数组中重复数字 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null || numbers.length<=1 || duplication==null || duplication.length<=0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if( numbers[i]>numbers.length-1 ){
                return false;
            }
            if(numbers[i]==i) {
                continue;
            }
            if(numbers[numbers[i]]==numbers[i]){
                duplication[0] = numbers[i];
                return true;
            }
            swap(numbers, i, numbers[i]);
        }
        duplication[0] = -1;
        return false;
    }

    public void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = array[i];
    }
}
