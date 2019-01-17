class Solution {
    private int pos = 0;
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for(int i = pos ; i < s.length() ; i++){
            if(s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))){
                res.append(s.charAt(i));
            } else if(Character.isDigit(s.charAt(i))) {
                num.append(s.charAt(i));
            } else if(s.charAt(i) == '[') {
                pos = i + 1;
                String comp = decodeString(s);
                int count = Integer.parseInt(num.toString());
                for(int j = 0 ; j < count ; j++) res.append(comp);
                num = new StringBuilder();
                i = pos;
            } else if(s.charAt(i) == ']') {
                pos = i;
                return res.toString();
            }
        }
        return res.toString();
    }
}
