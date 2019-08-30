import org.junit.Test;

import java.util.Arrays;

public class 排序算法 {


    public static void main(String[] args) {
        new 排序算法().sort();
    }
    public void sort() {
        int[] array = {1, 45, 7, 10, 1, 3, 4, 5};
        heapSort(array);
        Arrays.stream(array).forEach(e-> System.out.print(e + " "));
    }

    public void bubbleSort(int[] array){
        boolean sort = false;
        for (int i = 0; i < array.length && !sort; i++) {
            sort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j + 1);
                    sort = false;
                }
            }
        }
    }

    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >0 && array[j] < array[j-1]; j--) {
               swap(array, j, j - 1);
            }
        }
    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int max = 0;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            swap(array, array.length - i - 1, max);
        }
    }

    public void shellSort(int[] array) {
        int k = 1;
        while (k < array.length/3) {
            k = k * 3 + 1;
        }
        while (k > 0) {
            for (int i = k; i < array.length; i++){
                for (int j = i; j >= k && array[j] < array[j-k]; j-=k) {
                    swap(array, j, j-k);
                }
            }
            k /= 3;
        }
    }

    public void bottomUpMergeSort(int[] array) {
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length - gap; i+= 2 * gap) {
                merge(array, i, i + gap -1, Math.min(array.length-1, i + 2 * gap - 1));
            }
        }
    }

    public void topDownMergeSort(int[] array) {
        topDownMergeSort(array, 0, array.length-1);
    }

    public void topDownMergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r-l)/2;
        topDownMergeSort(array, l, m);
        topDownMergeSort(array, m+1, r);
        merge(array, l, m ,r);
    }


    public void merge(int[] array, int l, int m ,int r) {
        int[] tmp = new int[array.length];
        for (int k = l; k <= r; k++) {
            tmp[k] = array[k];
        }
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = tmp[j++];
            } else if (j > r) {
                array[k] = tmp[i++];
            } else if (tmp[i] > tmp[j]) {
                array[k] = tmp[j++];
            } else {
                array[k] = tmp[i++];
            }
        }
    }

    public void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int l, int r) {
        if (l>=r) {
            return;
        }
        int mid = partition(array, l, r);
        quickSort(array, l, mid);
        quickSort(array, mid+1, r);
    }

    public int partition(int[] array, int l, int r){
        int p = array[l];
        while(l<r) {
            while(l<r && array[r] >= p) {
                r--;
            }
            array[l] = array[r];
            while (l<r && array[l] < p) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = p;
        return l;
    }

    public void heapSort(int[] array) {
        int N = array.length - 1;
        // 建堆
        for (int i = (N-1)/2; i>=0; i--) {
            sink(array, i, N);
        }
        while (N>1) {
            swap(array, 0, N--);
            sink(array, 0, N);
        }
    }

    public void sink(int[] array, int k, int N) {
        while(2*k+1<N) {
            int tmp = 2*k+1;
            if (2*k+2 < N && array[2*k+2] > array[2*k+1]) {
                tmp = 2*k + 2;
            }
            if (array[tmp] <= array[k]) {
                break;
            }
            swap(array, tmp, k);
            k = tmp;
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
