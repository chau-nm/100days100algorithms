public class TernarySearch {
  
  public int ternarySearch(int left, int right, int[] arr, int target) {
    if (right <= 0) return -1;

    int middleLeft = left + ((right - left) / 3);
    int middleRight = right - ((right - left) / 3);

    if (arr[middleLeft] == target) {
      return middleLeft;
    }
    if (arr[middleRight] == target) {
      return middleRight;
    }

    if (target < arr[middleLeft]) {
      return ternarySearch(left, middleLeft - 1, arr, target);
    } else if (target > arr[middleRight]) {
      return ternarySearch(middleRight + 1, right, arr, target);
    } else {
      return ternarySearch(middleLeft + 1, middleRight - 1, arr, target);
    }
  }

  public int search(int[] arr, int target) {
    return ternarySearch(0, arr.length - 1, arr, target);
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    TernarySearch ternarySearch = new TernarySearch();
    System.out.println(ternarySearch.search(arr, 3));
  }
}
