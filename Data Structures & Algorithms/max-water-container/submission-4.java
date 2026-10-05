class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int l = 0, r = heights.length - 1;
        // (r - l) * min(heights[r], heights[l]);
        while (r > l) {
            int area = (r - l) * Math.min(heights[r], heights[l]);
            result = Math.max(result, area);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
