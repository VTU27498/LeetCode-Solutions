class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int j=0;
       Stack<Integer> s= new Stack<>();
       
        for(int input:pushed)

        {
            s.push(input);
            while(!s.isEmpty()&&j<popped.length && s.peek()==popped[j]){
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
}