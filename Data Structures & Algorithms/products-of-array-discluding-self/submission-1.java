class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalMult=1;
        boolean containsZero=false;
        int countZeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                totalMult = nums[i]*totalMult;
            }else{
                containsZero =true;
                countZeros++;
            }
        }
        int[] result = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(containsZero){
                    result[i]=0;
                }else{
                    result[i]=totalMult/nums[i];
                }
            }else{
                if(containsZero){
                    if(countZeros>1){
                        result[i]=0;
                    }else{
                        result[i]=totalMult;
                    }
                    
                }else{
                    result[i]=totalMult;
                }
                
            }
        }

        return result;
    }
}  
