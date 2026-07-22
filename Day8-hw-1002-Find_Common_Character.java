mport java.util.*;
class Solution {
    public List<String> commonChars(String[] words) {
        List<Character> common = new ArrayList<>();
        for (char c : words[0].toCharArray()) {
            common.add(c);
        }
        for (int i = 1; i < words.length; i++) {
            List<Character> temp = new ArrayList<>();
            String current = words[i];
            for (char c : common) {
                int index = current.indexOf(c);
                if (index != -1) {
                    temp.add(c);
                    current = current.substring(0, index) + current.substring(index + 1);
                }
            }
            common = temp;
        }
        List<String> result = new ArrayList<>();
        for (char c : common) {
            result.add(String.valueOf(c));
        }
        return result;
    }
}
