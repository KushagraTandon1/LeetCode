class Solution {

    public void buildList(TreeNode root, Map<Integer, Set<Integer>> adjacencyList){
        if(root == null) return;

        int root_val = root.val;
        adjacencyList.putIfAbsent(root_val, new HashSet<>());
        
        if(root.left != null){
            int left_val = root.left.val;
            adjacencyList.putIfAbsent(left_val, new HashSet<>());
            adjacencyList.get(root_val).add(left_val);
            adjacencyList.get(left_val).add(root_val);
        }

        if(root.right != null){
            int right_val = root.right.val;
            adjacencyList.putIfAbsent(right_val, new HashSet<>());
            adjacencyList.get(root_val).add(right_val);
            adjacencyList.get(right_val).add(root_val);
        }

        buildList(root.left, adjacencyList);
        buildList(root.right, adjacencyList);

    }

    public int amountOfTime(TreeNode root, int start) {
        
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int answer = -1;
        buildList(root, adjacencyList);
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                for(int adjacent: adjacencyList.get(node)){
                    if(!visited.contains(adjacent)){
                        queue.offer(adjacent);
                        visited.add(adjacent);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}