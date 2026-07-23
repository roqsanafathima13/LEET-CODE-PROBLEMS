import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger mult = a.multiply(b);
        return mult.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.multiply("123456789", "987654321"));
    }
}
