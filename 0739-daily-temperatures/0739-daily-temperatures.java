class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop all days that are not warmer
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            
            // If stack not empty, top is the next warmer day
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            
            // Push current day index
            stack.push(i);
        }
        
        return ans;
    }
}

