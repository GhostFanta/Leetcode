class Solution {
    int res;
    public int countSubstrings(String s) {
        res = 0;
        expand(s,0);
        return this.res;
    }

    public void expand(String s, int index){
        for(int i = 0 ; i < s.length() ; i++){

            this.res++;
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && right < s.length()){
                if(s.charAt(left--) == s.charAt(right++)){
                    this.res++;
                } else {
                    break;
                }
            }

            if(i - 1 >= 0 && s.charAt(i) == s.charAt(i - 1)){
                int l = i - 1;
                int r = i;
                while(l >= 0 && r < s.length()){
                    if(s.charAt(l--) == s.charAt(r++)){
                        this.res++;
                    } else {
                        break;
                    } 
                }
            }
        }
    }
}
