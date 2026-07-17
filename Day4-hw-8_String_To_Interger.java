class Solution {
    public int myAtoi(String s) {
        // Define integer limits
        int INT_MAX = Integer.MAX_VALUE;   //  2^31 - 1
        int INT_MIN = Integer.MIN_VALUE;   // -2^31

        int i = 0, n = s.length();
        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits
        long num = 0; // use long to detect overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;

            // Step 4: Clamp if overflow
            if (sign == 1 && num > INT_MAX) return INT_MAX;
            if (sign == -1 && -num < INT_MIN) return INT_MIN;

            i++;
        }

        return (int)(sign * num);
    }
}
