class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int[] res = {-1,-1};

        while(left < nums.length && right < nums.length && left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                res[0] = searchL(nums, target, 0, mid);
                res[1] = searchR(nums, target, mid, nums.length - 1);
                return res;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return res;
    }

    public int searchL(int[] nums, int target, int left, int right){
        int mid = -1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                if(mid - 1 < 0){
                    return mid;
                } else if(nums[mid - 1] < target){
                    return mid;
                } else {
                    right = mid;
                }
            } else{
                left = mid + 1;
            }         
        }
        return mid;
    }

    public int searchR(int[] nums, int target, int left, int right){
        int mid = -1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                if(mid + 1 >= nums.length){
                    return mid;
                } else if(nums[mid + 1] > target){
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] > target){
                right = mid;
            }         
        }
        return mid;
    }
}
