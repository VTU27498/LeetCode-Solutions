class Solution {
    public String largestNumber(int[] nums) {

        // Convert integers to strings
        String[] arr = Arrays.stream(nums)
                             .mapToObj(String::valueOf)
                             .toArray(String[]::new);

        // Sort using lambda comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is "0"
        if (arr[0].equals("0")) return "0";

        // Join using Java 8 String.join
        return String.join("", arr);
    }

        
    }
        