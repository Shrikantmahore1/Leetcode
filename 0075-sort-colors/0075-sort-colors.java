class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {          // Outer loop
            for (int j = 0; j < n - i - 1; j++) {  // Inner loop
                if (nums[j] > nums[j + 1]) {
                    // Swap elements
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
