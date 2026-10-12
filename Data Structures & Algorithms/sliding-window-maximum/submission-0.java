class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        // Each entry: {value, index}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int right = 0; right < nums.length; right++) {
            pq.offer(new int[]{nums[right], right});

            // Remove expired elements when they reach the top.
            while (pq.peek()[1] <= right - k) {
                pq.poll();
            }

            if (right >= k - 1) {
                result[right - k + 1] = pq.peek()[0];
            }
        }

        return result;
    }
    
}

