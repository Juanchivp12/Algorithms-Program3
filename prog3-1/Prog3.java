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

        // Inversion count
        int count = 0;

        // Find mid index
        int mid = (left + right) / 2;

        // Recursive calls
        count += Recur(arr, left, mid); // merge sort call for left side
        count += Recur(arr, mid+1, right); // merge sort call for right size
        count += merge(arr, left, mid, right); // merge call to merge the two sorted halves

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
        // Find the size of the left and right arrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        MyObj[] leftHalfArray = new MyObj[leftSize]; // Left array
        MyObj[] rightHalfArray = new MyObj[rightSize]; // right array

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
                count += rightSize - j; // if less, then add not only this inversion but the rest on that half since they are all greater
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
        // Preprocessing code here
        Prog3 prog3 = new Prog3();

        // Make a single call to Recur()
        int inversions = prog3.Recur(arr, 0, arr.length - 1);

        // Return the right value
        return inversions;
    }
}
