import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    stack.pop(); // smaller right asteroid destroyed
                    continue;
                } else if (stack.peek() == -a) {
                    stack.pop(); // both destroyed
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        // Convert stack to array (reverse order since we used push)
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
