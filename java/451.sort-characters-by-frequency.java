class Obj{
    public char key;
    public int val;

    public Obj(char keyi, int vali){
        this.key = keyi;
        this.val= vali;
    }
}

class Solution {
    public String frequencySort(String s) {
        if(s.length() < 1){
            return s;
        }
        Map<Character, Integer> store = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            store.put(s.charAt(i), store.getOrDefault(s.charAt(i), 0) + 1);
        }
        Comparator<Obj> crit = new Comparator<Obj>() {
            public int compare(Obj a, Obj b){
                return b.val - a.val;
            }
        };
        PriorityQueue<Obj> sorting = new PriorityQueue<>(store.keySet().size(), crit);
        for(Character i: store.keySet()){
            sorting.add(new Obj(i, store.get(i)));
        }

        StringBuilder sb = new StringBuilder();
        while(!sorting.isEmpty()){
            Obj mem = sorting.poll();
            for(int i = 0 ; i < mem.val ; i++){
                sb.append(mem.key);
            }
        }
        return sb.toString();
    }
}

