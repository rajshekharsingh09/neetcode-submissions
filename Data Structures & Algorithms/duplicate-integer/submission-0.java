class Solution {
    public boolean hasDuplicate(int[] nums) {
        int count =0;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i =0;i<nums.length;i++){
            if(mp.containsKey(nums[i]))return true;

            mp.put(nums[i],1);
        }
        return false;
        
    }
}