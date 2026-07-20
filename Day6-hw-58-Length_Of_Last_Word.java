class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // Step 1
        int lastSpace = s.lastIndexOf(' '); // Step 2
        return s.length() - lastSpace - 1;  // Step 3
    }
}
