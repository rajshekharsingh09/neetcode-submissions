class Solution {
    public int search(int[] nums, int target) {
        int first = findMin(nums);
        int left,right;
        if(first > 0 && nums[0]<= target && target<=nums[first-1]){
            left = 0;
            right =first-1;
        }else{
            left = first;
            right = nums.length-1;
        }

        while(left<right){
            int mid= left + (right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left]==target?left:-1;
        
    }

    public int findMin(int[] nums){
        int left=0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right =mid;
            }
        }
        return left;
    }
}
