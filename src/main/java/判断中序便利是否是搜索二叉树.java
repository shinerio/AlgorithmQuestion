public class 判断中序便利是否是搜索二叉树 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean verifySequenceOfBST(int [] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int rootVal = sequence[end];
        int leftRoot = start;
        while (leftRoot < end && sequence[leftRoot] <= rootVal) {
            leftRoot++;
        }
        for (int i = leftRoot; i < end; i++)
            if (sequence[i] < rootVal)
                return false;
        return verifySequenceOfBST(sequence, start, leftRoot-1) && verifySequenceOfBST(sequence, leftRoot, end-1);
    }

    public static void main(String[] args) {
        System.out.println(new 判断中序便利是否是搜索二叉树().VerifySquenceOfBST(new int[]{3, 2, 1}));
    }
}
