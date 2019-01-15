class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {

        Map<Character, Integer> store = new HashMap<>();
        List<String> res = new ArrayList<>();
            

        for(String n : B){
            int[] dic = new int[26];
            for(int m = 0 ; m < n.length() ; m++){
                dic[n.charAt(m) - 'a']++;
            }
            for(int i = 0 ; i < 26 ; i++){
                store.put((char)('a' + i), Math.max(store.getOrDefault((char)('a' + i), 0), dic[i]));
            }
        }

        for(String n : A){
            boolean flag = true;
            Map<Character, Integer> dic = new HashMap<>();

            for(char i : n.toCharArray()){
                dic.put(i, dic.getOrDefault(i,0) + 1);
            }

            for(char i : store.keySet()){
                if(dic.getOrDefault(i,0) < store.getOrDefault(i,0)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(n);
            }
        }
        return res;
    }
}
