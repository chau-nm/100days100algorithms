import java.util.Arrays;

public class MergeSort {

    public int[] merge(int[] arr1, int[] arr2) {
        int resultSize = arr1.length + arr2.length;
        int[] result = new int[resultSize];
        int i = 0;
        int j = 0;
        while (i + j < resultSize) {
            if (i > arr1.length - 1) {
                result[i + j] = arr2[j++];
                continue;
            }
            if (j > arr2.length - 1) {
                result[i + j] = arr1[i++];
                continue;
            }
            if (arr1[i] < arr2[j]) {
                result[i + j] = arr1[i++];
            } else {
                result[i + j] = arr2[j++];
            }
        }
        return result;
    }

    public int[] getSubarray(int[] arr, int startIndex, int endIndex) {
        if (endIndex < startIndex || endIndex >= arr.length || startIndex < 0) {
            return new int[] {};
        }
        int size = endIndex - startIndex + 1;
        int[] subarray = new int[size];
        int currentIndex = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            subarray[currentIndex++] = arr[i];
        }
        return subarray;
    }

    public int[] mergeSortRecursive(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int middleIndex = (arr.length - 1) / 2;
        int[] left = mergeSortRecursive(getSubarray(arr, 0, middleIndex));
        int[] right = mergeSortRecursive(getSubarray(arr, middleIndex + 1, arr.length - 1));
        return merge(left, right);
    }
    
    public int[] sort(int[] arr) {
        return mergeSortRecursive(arr);
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,9,4,-5,-2,4};
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(arr)));
    }
}
