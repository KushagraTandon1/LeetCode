class Node{

    Node [] link;
    boolean endOfWord;
    
    Node(){
        link = new Node[26];
    }

    public void put(char ch, Node node){
        link[ch - 'a'] = node;
    }

    public boolean contains(char ch){
        return link[ch - 'a'] != null;
    }

    public Node get(char ch){
        return link[ch - 'a'];
    }

    public void setEndOfWord(){
        endOfWord = true;
    }

    public boolean isEndOfWord(){
        return endOfWord;
    }

}

class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEndOfWord();

    }
    
    public boolean helper(String word, int index, Node node){
        if(index == word.length()) return node.isEndOfWord();
        
        char ch = word.charAt(index);
        
        if(ch == '.'){
            for(Node child : node.link){
                if(child != null && helper(word, index + 1, child)) return true;
            }
            return false;
        }

        if(!node.contains(ch)) return false;
        return helper(word, index + 1, node.get(ch));

    }
    public boolean search(String word) {
       return helper(word, 0, root);
    }
}
