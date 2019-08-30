import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 最少搬出教室人数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] relation = new int[n][n];
        int k = 0;
        while(k < m && sc.hasNextInt()) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            sc.nextLine();
            a1--;
            a2 = a2-n-1;
            relation[a1][a2] = 1;
            k++;
        }
        int count = 0;
        List<Integer> out = new ArrayList<>();

        int[] sum = new int[2*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += relation[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+n] += relation[j][i];
            }
        }
        for(int i = 0 ; i<n; i++) {
            int max = 0;
            int maxIndex = 0;
            for(int j=0 ; j< 2*n; j++) {
                if(sum[j] > max) {
                    max = sum[j];
                    maxIndex = j;
                }
            }
            if (max == 0) {
                break;
            } else {
                count++;
                out.add(maxIndex+1);
                sum[maxIndex] = 0;
            }
            if (maxIndex < n) {
                for (int j =0; j<n ;j++){
                    if(relation[maxIndex][j] == 1) {
                        sum[j+n]--;
                    }
                }
            } else {
                for (int j =0; j<n ;j++){
                    if(relation[j][maxIndex-n] == 1) {
                        sum[j]--;
                    }
                }
            }
        }

        System.out.println(count);
        for(int i =0 ; i < out.size()-1; i++) {
            System.out.print(out.get(i) + " ");
        }
        System.out.print(out.get(out.size()-1));
    }
}

