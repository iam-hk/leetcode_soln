class KthLargest {
    final PriorityQueue<Integer>pq;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>(k);
        for(int i:nums)
        pq.add(i);

    }
    
    public int add(int val) {
        pq.add(val);
        pop();
        return pq.peek();
    }
    public void pop(){
        while(pq.size() > k){
            pq.remove();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */