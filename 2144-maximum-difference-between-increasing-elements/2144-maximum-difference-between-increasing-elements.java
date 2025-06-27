class Solution {
    public int maximumDifference(int[] nums) {
        int min=Integer.MAX_VALUE,ans=-1;
        for(int num:nums)
        {
            if(min<num)
            {
                ans=Math.max(num-min,ans);
            }
            min=Math.min(num,min);
        }
        return ans;
    }
}