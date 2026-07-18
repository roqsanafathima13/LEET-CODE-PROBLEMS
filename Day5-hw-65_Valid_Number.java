class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); // remove leading/trailing spaces
        if (s.isEmpty()) return false;

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // sign is only valid at start or right after exponent
                if (i > 0 && !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    return false;
                }
            } else if (c == '.') {
                // dot is only valid if not seen before and not after exponent
                if (seenDot || seenExp) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // exponent must not be seen before and must follow a digit
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                seenDigit = false; // reset, must see digits after exponent
            } else {
                return false; // invalid character
            }
        }

        return seenDigit; // must end with a digit
    }
}
