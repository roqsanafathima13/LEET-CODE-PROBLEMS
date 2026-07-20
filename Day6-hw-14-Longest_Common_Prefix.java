class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // Step 1
        for (int i = 1; i < strs.length; i++) { // Step 2
            while (!strs[i].startsWith(prefix)) { // Step 3
                prefix = prefix.substring(0, prefix.length() - 1); // Step 4
                if (prefix.isEmpty()) return ""; // Step 5
            }
        }
        return prefix; // Step 6
    }
}
