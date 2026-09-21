class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int target = -nums[i];

            int j =i+1;
            int k = nums.length-1;

            while(j<k){

                if(nums[j]+nums[k]<target){
                    j++;
                }
                else if(nums[j]+nums[k]>target){
                    k--;
                }else{
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    result.add(ls);

                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[j]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }

        return result;
        
    }
}
