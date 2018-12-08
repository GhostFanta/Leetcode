class Solution {
    public String customSortString(String S, String T) {

        Map<Integer, Character> indextoChar = new HashMap<>();
        Set<Character> dic = new HashSet<>();
        Map<Character, Integer> amount = new HashMap<>();
        StringBuilder rest = new StringBuilder();
 
        for(int i = 0 ; i < S.length() ; i++){
            indextoChar.put(i,S.charAt(i));
            dic.add(S.charAt(i));
        }

        for(int i = 0 ; i < T.length() ; i++){
            Character t = T.charAt(i);
            if(dic.add(t)){
                dic.remove(t);
                rest.append(t);
            } else {
                amount.put(t, amount.getOrDefault(t,0) + 1);
            }
        }

        StringBuilder pattern = new StringBuilder();

        for(int i = 0 ; i < S.length() ; i++){
            Character ch = indextoChar.get(i);
            int num = amount.getOrDefault(ch,0);
            for(int j = 0 ; j < num ; j++){
                pattern.append(ch);
            }
        }

        return pattern.toString() + rest.toString();
    }
}
