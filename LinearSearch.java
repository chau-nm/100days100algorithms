public class LinearSearch {

  public static int search(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) return i;
    }    
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {4, 2, 3, 4, 5, 6};
    int target = 2;
    System.out.println("Index of 2: " + search(arr, target));
  }
}