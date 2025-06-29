import java.util.*;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                if (nums[j] == key) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}
