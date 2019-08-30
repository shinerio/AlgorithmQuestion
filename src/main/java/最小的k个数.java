import java.io.InputStream;
import java.util.ArrayList;

public class 最小的k个数 {

    public static void main(String[] args) {
        new 最小的k个数().GetLeastNumbers_Solution(new int[] {4,5,1,6,2,7,3,8}, 4).forEach(System.out::println);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return ret;
        }
        findSmallestK(input, k, 0, input.length-1);
        for(int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    public void findSmallestK(int [] input, int k, int l, int r) {
        if (k==0 || l==r) {
            return;
        }
        int index = partition(input, 0, input.length-1);
        if (index+1<k) {
            findSmallestK(input, k-index-1, index+2, r);
        }else if(index+1 > k) {
            findSmallestK(input, k, l, index+1);
        }else{
            return;
        }
    }

    public int partition(int [] input,  int l, int r) {
        int cur = input[l];
        while(l < r) {
            while(l < r && input[r] >= cur){
                r--;
            }
            input[l] = input[r];
            while(l < r && input[l] <= cur){
                l++;
            }
            input[r] = input[l];
        }
        input[l] = cur;
        return l;
    }
}
