public class SentinelLinearSearch {

  public int search(int[] arr, int target) {
    int lastIndex = arr.length - 1;
    int last = arr[lastIndex];
    arr[lastIndex] = target;
    
    int index = 0;
    while (arr[index] != target) {
      index++;
    }

    arr[lastIndex] = last;
    if (index < lastIndex || arr[lastIndex] == target) {
      return index;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {2,3,1,4,-1,-4,5};
    SentinelLinearSearch sentinelLinearSearch = new SentinelLinearSearch();
    System.out.println(sentinelLinearSearch.search(arr, 4));
  }
}