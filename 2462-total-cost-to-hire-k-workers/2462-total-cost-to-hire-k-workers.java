class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        int size = costs.length;
        PriorityQueue<Integer> headQueue = new PriorityQueue<>();
        PriorityQueue<Integer> tailQueue = new PriorityQueue<>();
        int headIndex = candidates, tailIndex = size - candidates - 1;

        for(int i = 0; i < candidates; i++){
            headQueue.offer(costs[i]);
        }

        for(int i = Math.max(candidates, size - candidates); i < size; i++){
            tailQueue.offer(costs[i]);
        }

        for(int i = 0; i < k; i++){
            if(tailQueue.isEmpty() || !headQueue.isEmpty() && headQueue.peek() <= tailQueue.peek()){
                cost += headQueue.poll();
                if(headIndex <= tailIndex){
                    headQueue.offer(costs[headIndex]);
                    headIndex++;
                }
            }else{
                cost += tailQueue.poll();
                if(headIndex <= tailIndex){
                    tailQueue.offer(costs[tailIndex]);
                    tailIndex--;
                }
            }
        }
        return cost;
    }
}