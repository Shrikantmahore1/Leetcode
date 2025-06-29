import java.util.*;

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        int low = 0, high = n;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = low++;
            } else {  // 'D'
                perm[i] = high--;
            }
        }
        // last slot gets the remaining number (low == high)
        perm[n] = low;
        return perm;
    }
}
