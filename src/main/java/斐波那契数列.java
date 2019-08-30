public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int ppre = 0;
        int pre = 1;
        int sum = 0;
        while (n-- > 1) {
            sum = ppre + pre;
            ppre = pre;
            pre = sum;
        }
        return sum;
    }
}

