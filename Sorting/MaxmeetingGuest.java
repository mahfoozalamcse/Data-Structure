package Sorting;

import java.util.Arrays;

public class MaxmeetingGuest {
    
    public static void findMaxGuests(int[] arr, int[] exit) {
        int n = arr.length;

        // Step 1: Sort arrival and exit times
        Arrays.sort(arr);
        Arrays.sort(exit);

        // Step 2: Initialize pointers for arrivals and exits
        int guestsIn = 1, maxGuests = 1, time = arr[0];
        int i = 1, j = 0;

        // Step 3: Process all events (arrival or exit)
        while (i < n && j < n) {
            if (arr[i] <= exit[j]) {
                guestsIn++; // one more guest entered
                if (guestsIn > maxGuests) {
                    maxGuests = guestsIn;
                    time = arr[i];
                }
                i++;
            } else {
                guestsIn--; // one guest left
                j++;
            }
        }

        System.out.println("Maximum guests = " + maxGuests + " at time = " + time);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 5, 5};
        int[] exit = {4, 5, 12, 9, 12};

        findMaxGuests(arr, exit);
    }

}
