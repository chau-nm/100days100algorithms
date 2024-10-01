public class JumpSearch {

  public int search(int[] arr, int target) {
    if (arr.length <= 0) return -1;
    
    int step = (int) Math.sqrt(arr.length);
    int prev = 0;

    while (arr[Math.min(step, arr.length) - 1] < target) {
      prev = step;
      step += (int) Math.sqrt(arr.length);
      if (prev >= arr.length) {
        return -1;
      }
    }

    for (int i = prev; i < step; i++) {
      if (arr[i] == target) {
        return i;
      } 
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1,3,5,6,7,8,9};
    JumpSearch jumpSearch = new JumpSearch();
    System.out.println(jumpSearch.search(arr, 3));
  }
}