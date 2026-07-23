class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];
        prev[0] = true;
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                prev[j] = prev[j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            curr = new boolean[n + 1]; 
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc== sc || pc == '.') {
                    curr[j] = prev[j - 1];
                } else if (pc == '*') {
                    curr[j] = curr[j - 2]; 
                    char prevChar = p.charAt(j - 2);
                    if (prevChar == sc || prevChar == '.') {
                        curr[j] = curr[j] || prev[j];
                    }
                }
            }
            prev = curr; 
        }
        return prev[n];
    }
}
