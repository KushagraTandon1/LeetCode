class Pair{
    String string; int minDepth;
    Pair(String string, int minDepth){
        this.string = string;
        this.minDepth = minDepth;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> isValid = new HashSet<>();
        HashSet<String> isVisited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        int minDepth = 0;
        int bankSize = bank.length;

        for(int i = 0; i < bankSize; i++) isValid.add(bank[i]);
        if(!isValid.contains(endGene)) return -1;
        queue.offer(new Pair(startGene, 0));
        
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            String node_string = node.string;
            int node_minDepth = node.minDepth;
            if(node_string.equals(endGene)) return node_minDepth;

            char [] stringArray = node_string.toCharArray();
            for(int i = 0; i < node_string.length(); i++){
                char original = stringArray[i];

                for(char ch : new char[] {'A', 'C', 'G', 'T'}){
                    stringArray[i] = ch;

                    String mutatedString = new String(stringArray);
                    if(!isVisited.contains(mutatedString)){
                        if(isValid.contains(mutatedString)){
                            queue.offer(new Pair(mutatedString, node_minDepth + 1));
                            isVisited.add(mutatedString);
                        }
                    }
                }
                stringArray[i] = original;
            }
        }
        return -1;
    }
}