class Pair{
    String node;
    double val;
    Pair(String node, double val){
        this.node = node;
        this.val = val;
    }
}

class Solution {
    public double bfs(String src, String target, Map<String, List<Pair>> adjacentList ){
        Queue<Pair> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        if(!adjacentList.containsKey(src) || !adjacentList.containsKey(target)) return -1.0;

        queue.offer(new Pair(src, 1.0));
        visited.add(src);

        while(queue.size() > 0){
            Pair nodePair = queue.poll();
            String node = nodePair.node;
            double val = nodePair.val;

            if(target.equals(node)) return val;
            for(Pair adjNode : adjacentList.get(node)){
                if(!visited.contains(adjNode.node)){
                    queue.offer(new Pair(adjNode.node, val * adjNode.val));
                    visited.add(adjNode.node);
                }
            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int size = queries.size();
        Map<String, List<Pair>>adjacentList = new HashMap<>();
        double [] answer = new double[size];
        Arrays.fill(answer, -1.0);
        for(int i = 0; i < equations.size(); i++){
            String src = equations.get(i).get(0);
            String dst = equations.get(i).get(1);
            adjacentList.putIfAbsent(src, new ArrayList<>());
            adjacentList.putIfAbsent(dst, new ArrayList<>());
            adjacentList.get(src).add(new Pair(dst, values[i]));
            adjacentList.get(dst).add(new Pair(src, 1/values[i]));
        }
        for(int i = 0; i < size; i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            answer[i] = bfs(src, dst, adjacentList);
        }
        return answer;
    }
}