class Solution {
    public String largestNumber(int[] nums) {
        Integer[] ar = new Integer[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ar[i] = nums[i];
        }
        Arrays.sort(ar, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                String f = a.toString() + b.toString();
                String s = b.toString() + a.toString();
                return s.compareTo(f);
            }
        });
        if(ar[0] == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ar){
            sb.append(i);
        }

        return sb.toString();
    }
}
