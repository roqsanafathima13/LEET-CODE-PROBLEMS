import java.util.*;
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;
        List<Integer> result = new ArrayList<>();
        for (int num = 100; num <= 999; num += 2) { 
            int a = num / 100;        
            int b = (num / 10) % 10;  
            int c = num % 10;         
            int[] need = new int[10];
            need[a]++; need[b]++; need[c]++;
            if (need[a] <= freq[a] && need[b] <= freq[b] && need[c] <= freq[c]) {
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
