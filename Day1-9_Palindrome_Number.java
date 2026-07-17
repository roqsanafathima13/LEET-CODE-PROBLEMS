class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int pop = x % 10;   // extract last digit
            x /= 10;            // remove last digit

            // Check for overflow before multiplying by 10
            if (reversed > Integer.MAX_VALUE / 10 || 
               (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return false;
            }

            reversed = reversed * 10 + pop;
        }

        return original == reversed;
    }
}
