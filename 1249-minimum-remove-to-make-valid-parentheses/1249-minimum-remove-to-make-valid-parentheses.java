class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        // First pass: remove invalid ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                    sb.append(c);
                }
                // else skip invalid ')'
            } else {
                sb.append(c);
            }
        }

        // Second pass: remove extra '(' from the end
        StringBuilder result = new StringBuilder();
        int balance = open;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && balance > 0) {
                balance--; // skip extra '('
            } else {
                result.append(c);
            }
        }

        return result.reverse().toString();
        
    }
}