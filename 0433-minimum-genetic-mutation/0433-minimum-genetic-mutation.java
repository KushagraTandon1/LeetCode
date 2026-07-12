class State{
    final String gene;
    final int mutation;
    State(String gene, int mutation){
        this.gene = gene;
        this.mutation = mutation;
    }
}

class Solution {
    final char [] words = new char[] {'A', 'C', 'G','T'};
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();
        Set<String> valid = new HashSet<>();
        Queue<State> queue = new ArrayDeque<>();
        for(String str : bank){
            valid.add(str);
        }
        queue.offer(new State(startGene, 0));

        while(!queue.isEmpty()){
            State state = queue.poll();
            String currentGene = state.gene;
            int currentMutation = state.mutation;
            visited.add(currentGene);
            if(currentGene.equals(endGene)) return currentMutation;
            char [] geneArray = currentGene.toCharArray();
            for(int i = 0; i < 8; i++){
                char original = geneArray[i];

                for(char ch : words){
                    geneArray[i] = ch;
                    if(ch == original) continue;

                    String newMutation = new String(geneArray);
                    if(valid.contains(newMutation) && visited.add(newMutation)){
                        queue.offer(new State(newMutation, currentMutation + 1));
                    }   
                }
                geneArray[i] = original;
            }
        }   
        return -1;
    }
}