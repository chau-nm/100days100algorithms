import java.util.Arrays;

public class InsertionSort {

    public int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,9,4,-5,-2,4};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.sort(arr)));
    }
}