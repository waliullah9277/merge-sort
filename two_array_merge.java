import java.util.*;
import java.util.stream.IntStream;

public class two_array_merge {

    static void merge_sorting(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];
        int k = 0;

        for (int i = left; i <= mid; i++) {
            L[k] = arr[i];
            k++;
        }
        k = 0;
        for (int i = mid + 1; i <= right; i++) {
            R[k] = arr[i];
            k++;
        }

        int i = 0, j = 0;
        int cur = left;

        while (i < leftSize && j < rightSize) {
            if (L[i] <= R[j]) {
                arr[cur++] = L[i++];
            } else {
                arr[cur++] = R[j++];
            }
        }

        while (i < leftSize) {
            arr[cur++] = L[i++];
        }

        while (j < rightSize) {
            arr[cur++] = R[j++];
        }
    }

    static void divide(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide(arr, left, mid);
            divide(arr, mid + 1, right);

            merge_sorting(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of m: ");
        int m = in.nextInt();
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = in.nextInt();
        }

        System.out.print("Enter number of n: ");
        int n = in.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }

        int[] newArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();

        System.out.print("Given array list: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }

        divide(newArray, 0, newArray.length - 1);
        System.out.println();

        System.out.print("Sorting array list: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}