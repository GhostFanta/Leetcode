class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> store = new Stack<>();
        int index = 0;
        for(int i = 0 ; i < pushed.length ; i++){
            store.push(pushed[i]);
            while(index < popped.length && !store.isEmpty() && popped[index] == store.peek()){
                store.pop();
                index++;
            }
        }

        return store.isEmpty();
    }
}
