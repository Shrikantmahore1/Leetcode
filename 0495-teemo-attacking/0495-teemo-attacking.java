class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        
        int total = 0;
        int end = 0; // poison effect end time
        
        for (int t : timeSeries) {
            if (t >= end) {
                // No overlap with previous poison interval
                total += duration;
            } else {
                // Overlapping: add only the extra time beyond previous end
                total += (t + duration - end);
            }
            end = t + duration;
        }
        
        return total;
    }
}
