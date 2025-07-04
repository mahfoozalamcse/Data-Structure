package Hashing;

public class GivenSumsub {
  public static int givenSum(int arr[], int sum) {
        int curr_sum = 0, start = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Add current element to curr_sum
            curr_sum += arr[i];

            // While curr_sum exceeds the sum, shrink the window from the left
            while (curr_sum > sum && start <= i) {
                curr_sum -= arr[start];
                start++;
            }

            // If current sum becomes equal to sum, return the indices
            if (curr_sum == sum) {
                System.out.println("Sum found between indexes " + start + " and " + i);
                return 1;
            }
        }

        System.out.println("No subarray found");
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int sum = 23;
        givenSum(arr, sum);
    }
}

