import java.util.Arrays;

public class QuickSort {

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public int partition(int[] arr, int low, int hight) {
        int pivot = arr[hight];
        int i = low;
        for (int j = low; j < hight; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hight);
        return i;
    }
    
    public void quickSort(int[] arr, int low, int hight) {
        if (low > hight) {
            return;
        }
        int pivotIndex = partition(arr, low, hight);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, hight);
    }

    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,9,4,-5,-2,4};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(arr)));
    }
}
