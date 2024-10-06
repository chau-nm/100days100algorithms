import java.util.Arrays;

public class BubbleSort {

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,12,-4,5};
        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedArr = bubbleSort.sort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
