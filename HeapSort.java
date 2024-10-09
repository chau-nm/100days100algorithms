
import java.util.Arrays;

public class HeapSort {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void heapify(int[] arr, int range,int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < range && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < range && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, range,largest);
        }
    }

    public int[] sort(int[] arr) {
        int length = arr.length;
        int startHeapify = length / 2 - 1;
        for (int i = startHeapify; i >= 0; i--) {
            heapify(arr, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9,4,3,8,10,2,5};
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(heapSort.sort(arr)));
    }
}
