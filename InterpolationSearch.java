public class InterpolationSearch {

  public int search(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high && target >= arr[low] && target <= arr[high]) {
      int position = low + (target - arr[low]) * (high - low) / (arr[high] - arr[low]);

      if (arr[position] == target) {
        return position;
      }

      if (arr[position] < target) {
        low = position + 1;
      } else {
        high = position - 1;
      }
    }
    return -1;
}


  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    InterpolationSearch interpolationSearch = new InterpolationSearch();
    System.out.println(interpolationSearch.search(arr, 3));
  }
}