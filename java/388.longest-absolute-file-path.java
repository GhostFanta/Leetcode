class Solution {
    public int lengthLongestPath(String input) {
        String[] comp = input.split("\\n");
        Stack<String> head = new Stack<String>();
        int curlen = 0;
        int maxlen = 0;
        for(int i = 0 ; i < comp.length ; i++){
            int curlevel = comp[i].lastIndexOf("\t") < 0 ? 0 : comp[i].lastIndexOf("\t") + 1;
            if(head.size() > curlevel){
                while(head.size() > curlevel){
                    String temp = head.pop();
                    curlen -= (temp.length() + 1);
                }
            }
            head.push(comp[i].substring(curlevel));
            curlen += comp[i].substring(curlevel).length() + 1;
            if(comp[i].contains(".")){
                maxlen = maxlen > curlen - 1 ? maxlen : curlen - 1;
            }
        }
        return maxlen;
    }
}
