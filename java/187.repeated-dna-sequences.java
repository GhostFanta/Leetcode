class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> store = new ArrayList<>();
        if(s.length() < 10){
            return store;
        }
        int left = 0;
        int right = 10;

        Set<String> dup = new HashSet<>();
        Set<String> dup1 = new HashSet<>();

        for(int i = 0 ; i < s.length() - 9 ; i++){
            String cur = s.substring(left + i, right +i);
            if(!dup.add(cur)){
                dup1.add(cur);
            }
        }
        for(String i : dup1){
            store.add(i);
        }

        return store;
    }
}
