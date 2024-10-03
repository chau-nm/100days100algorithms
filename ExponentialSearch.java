public class ExponentialSearch {
  public int search(int[] arr, int target) {
    if (arr.length <= 0) {
      return -1;
    }

    if (arr[0] == target) {
      return arr[0];
    }

    int i = 1;
    while (i < arr.length - 1 && arr[i] < target) {
      i *= 2;
    }

    return new BinarySearch().searchRecursive(arr, i / 2, Math.min(i, arr.length - 1), target);
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    ExponentialSearch exponentialSearch = new ExponentialSearch();
    System.out.println(exponentialSearch.search(arr, 8));
  }
}