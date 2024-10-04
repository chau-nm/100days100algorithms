public class FibonacciSearch {
  
  public int search(int[] arr, int target) {
    int arrLength = arr.length;

    int fbm1 = 0;
    int fbm2 = 1;
    int fbm = fbm1 + fbm2;

    while (fbm < arrLength) {
      fbm1 = fbm2;
      fbm2 = fbm;
      fbm = fbm1 + fbm2;
    }

    int offset = -1;

    while (fbm > 1) {
      int i = Math.min(offset + fbm1, arrLength - 1);
      
      if (arr[i] > target) {
        fbm = fbm1;
        fbm1 = fbm2 - fbm;
        fbm2 = fbm - fbm1;
      } else if (arr[i] < target) {
        fbm = fbm2;
        fbm2 = fbm1;
        fbm1 = fbm - fbm2;
        offset = i;
      } else {
        return i;
      }
    }

    if (fbm2 == 1 && arr[offset + 1] == target) {
      return offset + 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
    FibonacciSearch fibonacciSearch = new FibonacciSearch();
    System.out.println(fibonacciSearch.search(arr, 85));
  }
}
