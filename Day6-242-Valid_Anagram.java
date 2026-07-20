import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;   // Step 1: lengths must match
        char[] a = s.toCharArray(), b = t.toCharArray(); // Step 2: convert strings to char arrays
        Arrays.sort(a); Arrays.sort(b);                  // Step 3: sort both arrays
        return Arrays.equals(a, b);                      // Step 4: compare sorted arrays
    }
}
