class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> store = new ArrayList<>();
        Map<String, List<String>> dic = new HashMap<>();

        for(String i : strs){
            char[] demo = i.toCharArray();
            Arrays.sort(demo);
            String key = new String(demo);
            List<String> container = dic.getOrDefault(key, new ArrayList<String>());
            container.add(i);
            dic.put(key, container);
        }

        for(String i : dic.keySet()){
            store.add(dic.get(i));
        }
        return store;
    }
}
