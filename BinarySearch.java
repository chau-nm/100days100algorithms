

public class BinarySearch {

  public int searchRecursive(int[] arr, int low, int hight, int target) {
    if (hight < low) return -1;
    int middle = (hight + low) / 2;
    int middleValue = arr[middle];
    if (middleValue == target) {
      return middle;
    }
    if (middleValue > target) {
      return searchRecursive(arr, low, middle - 1, target);
    }
    return searchRecursive(arr, middle + 1, hight, target);
  }

  public int search(int[] arr, int target) {
    return searchRecursive(arr, 0, arr.length - 1, target);
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    BinarySearch binarySearch = new BinarySearch();
    System.out.println(binarySearch.search(arr, 3));
  }
}