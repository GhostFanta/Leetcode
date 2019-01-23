class Solution {
    private boolean flag = false;
    public boolean reorderedPowerOf2(int N) {
        List<Integer> store = new ArrayList<>();
        if(N == 0){
            return false;
        }
        while(N > 0){
            store.add(N % 10);
            N /= 10;
        }
        helper(new StringBuilder(), store, new int[store.size()]);
        return this.flag;
    }

    public void helper(StringBuilder sb, List<Integer> dic, int[] flags){
        if(sb.length() == dic.size()){
            if(sb.charAt(0) == '0'){
                return;
            }
            Integer test = Integer.parseInt(sb.toString());
            while(test > 1 && (test & 1) == 0) {
                test >>= 1;
            }
            if(test == 1){
                this.flag = true;
            }
        }

        for(int i = 0; i < dic.size() ; i++){
            if(flags[i] == 1){
                continue;
            }
            flags[i] = 1;
            sb.append(dic.get(i).toString());
            helper(sb, dic, flags);
            flags[i] = 0;
            sb.setLength(sb.length() - 1);
        }
    }
}
