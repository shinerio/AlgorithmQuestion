import java.util.ArrayList;

public class 和为s的连续整数序列 {
    public static void main(String[] args) {
        new 和为s的连续整数序列().FindContinuousSequence(9);
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (sum<3){
            return ret;
        }
        int count = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 1; i<=sum/2+1; i++){
            tmp.add(i);
            count += i;
            while (count > sum){
                count -= tmp.remove(0);
            }
            if (count == sum){
                ret.add(tmp);
                tmp = new ArrayList<>(tmp);
                tmp.remove(0);
            }
        }
        return ret;
    }
}
