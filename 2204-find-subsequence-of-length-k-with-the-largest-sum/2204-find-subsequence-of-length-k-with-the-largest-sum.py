import heapq

class Solution(object):
    def maxSubsequence(self, nums, k):
        heap = []
        for i, num in enumerate(nums):
            heapq.heappush(heap, (num, i))
            if len(heap) > k:
                heapq.heappop(heap)
        indices = sorted([idx for _, idx in heap])
        return [nums[i] for i in indices]