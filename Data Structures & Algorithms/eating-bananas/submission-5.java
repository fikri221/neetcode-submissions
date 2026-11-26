class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElseThrow();

        while (left < right) {
            int mid = (left + right) / 2;
            int total_hour = 0;
            for (int i = 0; i < piles.length; i++) {
                total_hour += (piles[i] + mid - 1) / mid;
            }

            if (total_hour <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
