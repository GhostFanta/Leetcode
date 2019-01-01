class Solution {
    public boolean isSubsequence(String s, String t) {
        int master = 0;
        int slave = 0;
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        while(slave < sa.length && master < ta.length){
            if(sa[slave] == ta[master]){
                master++;
                slave++;
            } else {
                master++;
            }
        }

        if(slave == sa.length){
            return true;
        } else {
            return false;
        }
    }
}
