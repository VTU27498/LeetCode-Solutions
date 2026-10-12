class RecentCounter {
    private Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t); // add the new request
        // remove requests older than t - 3000
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size(); // number of valid requests
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */