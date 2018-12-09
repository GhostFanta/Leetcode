class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> flag = new HashSet<>();

        visits(flag, rooms, 0);

        return flag.size() == rooms.size();
    }

    public void visits(Set<Integer> flag, List<List<Integer>> rooms, int key){
        if(flag.size() == rooms.size() || flag.contains(key)){
            return;
        }

        flag.add(key);

        List<Integer> room = rooms.get(key);

        for(int i = 0 ; i < room.size() ; i++){
            visits(flag, rooms, room.get(i));
        }

    }
}
