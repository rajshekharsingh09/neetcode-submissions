class Solution {
    public int[] productExceptSelf(int[] nums) {
       
       int[] preprod = new int[nums.length];
       int[] postprod = new int[nums.length];

       preprod[0]=1;
       postprod[nums.length-1]=1;

       for(int i=1;i<nums.length;i++){
        preprod[i]=preprod[i-1]*nums[i-1];
       }
       for(int j=nums.length-2;j>=0;j--){
        postprod[j]=postprod[j+1]*nums[j+1];
       }
       int[] result = new int[nums.length];
       for(int i=0;i<nums.length;i++){
        result[i]=preprod[i]*postprod[i];
       }
       return result;
    }
}  
