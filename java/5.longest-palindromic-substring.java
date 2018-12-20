import java.lang.*;
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for(int i = 0 ; i < s.length() ; i++){
            if(i >= 1){
                String s1 = expand(s, i, i);
                String s2 = expand(s, i - 1, i);
                if(s1.length() > s2.length()){
                    if(s1.length() > max){
                        max = s1.length();
                        res = s1;
                    }
                } else {
                    if(s2.length() > max){
                        max = s2.length();
                        res = s2;
                    }
                }
            } else {
                String sn = expand(s, i, i);
                if(sn.length() > max){
                    max = sn.length();
                    res = sn;
                }
            }
        }
        return res;
    }

    public String expand(String s, int left, int right){
        if(left < 0 || right > s.length() - 1 || s.charAt(left) != s.charAt(right)){
            return s.substring(left + 1, right);
        } else {
            return expand(s, left - 1, right + 1);
        }
    }
}
