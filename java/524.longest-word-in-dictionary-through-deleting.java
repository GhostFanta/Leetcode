class Solution {
    private boolean comparePattern (String target, String pattern){
        int top = 0;
        int bottom = 0;
        while(top < target.length() && bottom < pattern.length()){
            if(target.charAt(top) == pattern.charAt(bottom)){
                top++;
                bottom++;
            } else {
                bottom++;
            }
        }

        if(top == target.length()){
            return true;
        } else {
            return false;
        }
    }
    public String findLongestWord(String s, List<String> d) {
        List<String> res = new ArrayList<>();
        int max = 0;
        Collections.sort(d, new Comparator<String>(){
            public int compare(String a, String b){
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }
                return a.length() - b.length();
            }
        });

        for(String i : d){
            if(comparePattern(i, s)){
                if(i.length() == max){
                    res.add(i);
                } else if(i.length() > max){
                    max = i.length();
                    res.clear();
                    res.add(i);

                }
            }
        }

        Collections.sort(res);
        return res.size() == 0 ? "" : res.get(0);
    }
}
