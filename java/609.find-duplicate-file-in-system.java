class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> store = new HashMap<>();
        for(String path : paths){
            String[] comps = path.split(" ");
            for(int i = 1 ; i < comps.length ; i++){
                String[] temp = comps[i].split("\\(");
                List<String> content = store.getOrDefault(temp[1], new ArrayList<String>());
                content.add(comps[0] + "/" + temp[0]);
                store.put(temp[1], content);
            }
        }
        List<List<String>> res =  new ArrayList<>();
        for(String i : store.keySet()){
            if(store.get(i).size() < 2){
                continue;
            }
            res.add(store.get(i));
        }

        return res;
    }
}
