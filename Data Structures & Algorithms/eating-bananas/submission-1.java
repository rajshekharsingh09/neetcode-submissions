class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = 0;

            for (int pile : piles) {
                // ceil(pile / mid), using integer arithmetic
                hours += (pile + (long) mid - 1) / mid;
            }

            if (hours <= h) {
                right = mid;     // Valid speed; try a smaller one
            } else {
                left = mid + 1;  // Too slow; need a higher speed
            }
        }

        return left;
    }
}