public class 矩形覆盖 {
    // f(n) = f(n-1) + f(n-2)
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int ppre = 1;
        int pre = 2;
        int sum = 0;
        while (target-- > 2) {
            sum = ppre + pre;
            ppre = pre;
            pre = sum;
        }
        return sum;
    }
}
