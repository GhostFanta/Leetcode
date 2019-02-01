class Solution {
    // public int[] nextGreaterElements(int[] nums) {
    //     int[] nextIndex = new int[nums.length];
    //     for(int i = 0 ; i < nums.length ; i++){
    //         boolean flag = false;
    //         for(int j = 1 ; j < nums.length ; j++){
    //             if(nums[(i + j) % nums.length] > nums[i]){
    //                 nextIndex[i] = nums[(i + j) % nums.length];
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //         if(!flag){
    //             nextIndex[i] = -1;
    //         }
    //     }
    //     return nextIndex;

    // }

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> store = new Stack<Integer>();
        int[] res = new int[nums.length];

        for(int i = nums.length - 1 ; i >= 0; i--){
            if(store.isEmpty()){
                store.push(i);
                res[i] = -1;
                continue;
            }
            if(nums[i] >= nums[store.peek()]){
                while(!store.isEmpty() && nums[store.peek()] <= nums[i]){
                    store.pop();
                }
                if(store.isEmpty()){
                    res[i] = -1;
                } else {
                    res[i] = nums[store.peek()];
                }
                store.push(i);
            } else {
                res[i] = nums[store.peek()];
                store.push(i);
            }
        }

        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(store.isEmpty()){
                store.push(i);
                res[i] = -1;
                continue;
            }
            if(nums[i] >= nums[store.peek()]){
                while(!store.isEmpty() && nums[store.peek()] <= nums[i]){
                    store.pop();
                }
                if(store.isEmpty()){
                    res[i] = -1;
                } else {
                    res[i] = nums[store.peek()];
                }
                store.push(i);
            } else {
                res[i] = nums[store.peek()];
                store.push(i);
            }
        }

        return res;
    }
}
