class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> store = new Stack<>();
        char[] members = S.toCharArray();

        for(Character i : members){
            if(i == ')'){
                if(store.size() != 0 && store.peek() == '('){
                    store.pop();
                } else {
                    store.push(i);
                }
            } else {
                store.push(i);
            }
        }

        return store.size();
    }
}
