class Solution {
    public int binarysearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] >= nums[left] && nums[mid] <= nums[right]){
                return binarysearch(nums, left, right, target);
            }

            // pivot in left half
            if(nums[mid] <= nums[left] && nums[mid] <= nums[right]){
                // target in continuous range
                if(nums[mid] < target && target <= nums[right]){
                    return binarysearch(nums, mid + 1, right, target);
                } else {
                    return search(nums, left, mid - 1,target); 
                }
            // pivot in right half
            } else if(nums[mid] >= nums[left] && nums[mid] >= nums[right]){
                if( target >= nums[left] && target < nums[mid]){
                    return binarysearch(nums, left, mid - 1, target);
                } else {
                    return search(nums, mid + 1, right, target);
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return search(nums, left, right, target);
    }
}
