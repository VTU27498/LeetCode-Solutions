import java.util.*;
import java.util.stream.*;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        return IntStream.range(0, names.length)   // indices 0..n-1
                .boxed()                          // convert to Stream<Integer>
                .sorted((i, j) -> heights[j] - heights[i]) // sort by height descending
                .map(i -> names[i])               // map sorted indices to names
                .toArray(String[]::new);          // collect into array
    }
}
