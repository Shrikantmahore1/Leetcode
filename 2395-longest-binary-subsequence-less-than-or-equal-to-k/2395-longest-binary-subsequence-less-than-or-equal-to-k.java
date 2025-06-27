class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        int zeroCount = 0;
        long value = 0;
        int power = 0;

     
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '0') {
                count++;
            } else {
                // Try to include '1' if it doesn't exceed k
                if (power < 32) { // avoid overflow
                    value += 1L << power;
                    if (value <= k) {
                        count++;
                    } else {
                        // undo the last addition
                        value -= 1L << power;
                    }
                }
            }
            if (ch == '0' || (ch == '1' && power < 32 && (value + (1L << power) <= k))) {
                power++;
            }
        }

        return count;
    }
}
