import java.util.*;

public class second_largest_array {

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
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.print("Orginal array list: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }

        divide(arr, 0, n - 1);

        System.out.println();
        System.out.print("Sorting array list: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int largest = Math.max(arr[0], arr[1]);
        int secondLargest = Math.min(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        System.out.print("Second Largest value is "+secondLargest);
    }
}