package Recursion;

public class permutaion {

     public static void permute(String str, String result) {
        // Base case: if the input string is empty
        // we have a complete permutation in 'result'
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {

            // Choose one character from the string
            char ch = str.charAt(i);

            // Remaining string after removing the chosen character
            String remaining = str.substring(0, i) + str.substring(i + 1);

            // Recur with the remaining string and the current result + chosen character
            permute(remaining, result + ch);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
       // int n = str.length();

        System.out.println("All permutation : "+ str);
        permute(str, "");
        
    }
    
    
}
