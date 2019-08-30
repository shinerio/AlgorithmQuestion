import java.util.*;

public class 最小能分几组JD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stu = new int[n];
        int c = 0;
        while (c <n) {
            stu[c] = sc.nextInt();
            c++;
        }
        ArrayIndexComparator comparator = new ArrayIndexComparator(stu);
        Integer[] indexes = comparator.createIndexArray();
        Arrays.sort(indexes, comparator);
        List<List<Integer>> sub = new ArrayList<>();
        int split = 0;
        while (split < indexes.length) {
            int min = split;
            for (int i = split + 1; i < indexes.length; i++) {
                if (indexes[i] < indexes[min]) {
                    min = i;
                }
            }
            List<Integer> ssub = new ArrayList<>();
            for (int i = split; i <= min; i++) {
                ssub.add(stu[indexes[i]]);
            }
            sub.add(ssub);
            split = min +1;
        }
        System.out.print(sub.size());
    }

    public static class ArrayIndexComparator implements Comparator<Integer>
    {
        private final int[] array;

        public ArrayIndexComparator(int[] array)
        {
            this.array = array;
        }

        public Integer[] createIndexArray()
        {
            Integer[] indexes = new Integer[array.length];
            for (int i = 0; i < array.length; i++)
            {
                indexes[i] = i; // Autoboxing
            }
            return indexes;
        }

        @Override
        public int compare(Integer index1, Integer index2)
        {
            // Autounbox from Integer to int to use as array indexes
            return array[index1] - array[index2];
        }
    }
}
