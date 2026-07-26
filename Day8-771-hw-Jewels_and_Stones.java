class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        return (int) stones.chars()
                .filter(c -> jewels.indexOf(c) != -1)
                .count();
    }
}
