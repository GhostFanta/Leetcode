class Obj{
    public String word;
    public Integer freq;
    public Obj(String word, Integer freq){
        this.word = word;
        this.freq = freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> store = new HashMap<>();
        for(String i : words){
            store.put(i, store.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Obj> temp = new PriorityQueue<>(store.size(), new Comparator<Obj>(){
            public int compare(Obj a, Obj b){
                if(a.freq == b.freq){
                    return a.word.compareTo(b.word);
                };
                return b.freq - a.freq;
            }
        });

        for(String i : store.keySet()){
            temp.add(new Obj(i, store.get(i)));
        }

        List<String> res = new ArrayList<>();

        while(k > 0){
            res.add(temp.peek().word);
            temp.poll();
            k--;
        }

        return res;
    }
}
