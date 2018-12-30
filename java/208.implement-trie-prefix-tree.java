class Node {
    public boolean isEnd;
    public Node[] content;
    public Node() {
        isEnd = false;
        content = new Node[26];
    }
}
class Trie {

    public Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = this.root;
        for(Character i : word.toCharArray()){
            if(node.content[i - 'a'] == null){
                node.content[i - 'a'] = new Node();
                node = node.content[i - 'a'];
            } else {
                node = node.content[i - 'a'];
            }
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = this.root;
        for(Character i : word.toCharArray()){
            if(node == null){
                return false;
            } else {
                node  = node.content[i - 'a'];
            }
        }
        return node == null ? false : node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = this.root;
        for(Character i : prefix.toCharArray()){
            if(node == null){
                return false;
            } else {
                node  = node.content[i - 'a'];
            }
        }
        if(node == null){
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
