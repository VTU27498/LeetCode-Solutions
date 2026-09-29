class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 1: Compute prefix sums
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        
        int totalSum = prefix[n];
        
        // Step 2: Apply formula for each index
        for (int i = 0; i < n; i++) {
            int leftSum = i * nums[i] - prefix[i];
            int rightSum = (totalSum - prefix[i+1]) - (n - i - 1) * nums[i];
            result[i] = leftSum + rightSum;
        }
        
        return result;
    }
}
