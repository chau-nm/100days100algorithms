
import java.util.Arrays;

public class CountingSort {
    
    public int[] sort(int[] arr) {
        int length = arr.length;
        if (length <= 0) return arr;        
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] countArray = new int[max + 1];
        for (int i = 0; i < length; i++) {
            countArray[arr[i]]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] outputArray = new int[length];
        for (int i = 0; i < length; i++) {
            outputArray[--countArray[arr[i]]] = arr[i];
        }
        return outputArray;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,9,4,4};
        CountingSort countingSort = new CountingSort();
        System.out.println(Arrays.toString(countingSort.sort(arr)));
    }
}
