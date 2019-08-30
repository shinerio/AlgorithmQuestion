public class 二进制中1的个数    {
    public int NumberOf1(int n) {
        int sum = 0;
        while(n != 0) {
            sum++;
            n &= (n-1);
        }
        return sum;
    }
}
