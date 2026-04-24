import java.util.Arrays;

public class Prog3 {

    /**
     * For my implementation, I decided to go with a somehwat modified merge sort
     * @param arr the MyObj array to test
     * @param left left index of array
     * @param right right index of array
     * @return the inversion count
     */
    public int Recur(MyObj[] arr, int left, int right) {

        // Base case
        if (left >= right) {
            return 0;
        }

        int count = 0;
        int mid = (left + right) / 2;

        // Recursive calls
        count += Recur(arr, left, mid);
        count += Recur(arr, mid+1, right);
        count += merge(arr, left, mid, right);

        return count;
    }

    /**
     * Merge arrays
     * @param arr the array
     * @param left left index
     * @param mid mid index
     * @param right right index
     * @return number of inversions
     */
    private static int merge(MyObj[] arr, int left, int mid, int right) {
        int count = 0;
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        MyObj[] leftHalfArray = new MyObj[leftSize];
        MyObj[] rightHalfArray = new MyObj[rightSize];
//        MyObj[] leftHalfArray = Arrays.copyOfRange(arr, left+1, leftSize);
//        MyObj[] rightHalfArray = Arrays.copyOfRange(arr, mid+1, rightSize);

        // Copy elements into left and right halves
        for (int i = 0; i < leftSize; i++) {
            leftHalfArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightHalfArray[j] = arr[mid + 1 + j];
        }

        // Pointers
        int i = 0, j = 0, k = left;

        // Merge
        while (i < leftSize && j < rightSize) {
            if (leftHalfArray[i].lessThan(rightHalfArray[j])) {
                arr[k] = leftHalfArray[i++];
                count += rightSize - j;
            } else {
                arr[k] = rightHalfArray[j++];
            }
            k++;
        }

        // Copy left over elements
        while (i < leftSize) {
            arr[k++] = leftHalfArray[i++];
        }
        while (j < rightSize) {
            arr[k++] = rightHalfArray[j++];
        }
        return count;
    }

    /**
     * This method tests the algorithm
     * @param arr array to test
     * @return number of inversions
     */
    public static int Prog3(MyObj[] arr) {
        // Test for correctness
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].lessThan(arr[j])) {
                    count++;
                }
            }
        }
        System.out.println("\nResult: " + count);

        // Preprocessing code here
        Prog3 prog3 = new Prog3();

        // Make a single call to Recur()
        int inversions = prog3.Recur(arr, 0, arr.length - 1);

        // Return the right value
        return inversions;
    }
}
