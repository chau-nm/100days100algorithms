import java.util.Arrays;

public class SelectionSort {

  public void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  public int findMin(int[] arr, int startIndex, int endIndex) {
    int minIndex = startIndex;
    for (int i = startIndex + 1; i <= endIndex; i++) {
      if (arr[i] < arr[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public int[] sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = findMin(arr, i, arr.length - 1);
      if (minIndex != i) {
        swap(arr, i, minIndex);
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {2,3,1,2,12,-4,5};
    SelectionSort selectionSort = new SelectionSort();
    int[] sortedArr = selectionSort.sort(arr);
    System.out.println(Arrays.toString(sortedArr));
  }
}