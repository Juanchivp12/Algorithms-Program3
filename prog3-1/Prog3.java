
public class Prog3 {

   // you can change the parameters if you want, but you must return the correct answer for that array
   public int Recur(MyObj[] arr, int left, int right) {
      if (left >= right) {
         return 0; // no inversions, one element
      }

      int mid = (left + right) / 2;
      int count = 0;

      count += Recur(arr, left, mid);
      count += Recur(arr,mid + 1, right);
      count += merge(arr, left, mid + 1, right);
      return count;
	}

    private static int merge(MyObj[] arr, int left, int mid, int right) {
      int count = 0;
      MyObj[] leftArr = java.util.Arrays.copyOfRange(arr, left, mid);
      MyObj[] rightArr = java.util.Arrays.copyOfRange(arr, mid, right);

      return count;
    }


   public static int Prog3(MyObj[] arr) {
      // Preprocessing code here
      Prog3 prog3 = new Prog3();

      // Make a single call to Recur()
      int count = prog3.Recur(arr, 0, arr.length - 1);

      // Return the right value
      return count;
   }
}
