class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] comps = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String i : comps){
            int len = Integer.MAX_VALUE;
            String comp = i;
            for(String term : dict){
                if(i.startsWith(term) && term.length() < comp.length()){
                    len = term.length();
                    comp = term;
                }
            }
            sb.append(comp);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
