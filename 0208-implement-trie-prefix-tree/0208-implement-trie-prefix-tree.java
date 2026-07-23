class Node{

    Node [] linkage = new Node[26];
    boolean endOfWord;

    public void putChar(char ch, Node node){
        linkage[ch - 'a'] = node;
    }

    public Node getChar(char ch){
        return linkage[ch - 'a'];
    }

    public void markEndOfWord(){
        endOfWord = true;
    }

    public boolean isEndOfWord(){
        return endOfWord;
    }

    public boolean containsChar(char ch){
        return linkage[ch - 'a'] != null;
    }

}
class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        /** initially start with root and check whether the char is present in the linkage if yes then move forward else add that linkage */
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsChar(ch)){
                node.putChar(ch, new Node());
            }
            node = node.getChar(ch);
        }
        node.markEndOfWord();
    }

    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsChar(ch)) return false;
            node = node.getChar(ch);
        }
        return node.isEndOfWord();
    }

    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!node.containsChar(ch)) return false;
            node = node.getChar(ch);
        }
        return true;
    }
}

