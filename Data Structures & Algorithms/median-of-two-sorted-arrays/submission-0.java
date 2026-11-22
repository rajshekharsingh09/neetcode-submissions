class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int total = m+n;

        int low = 0;
        int high = n;
        int leftLength = (total+1)/2;

        while(low<=high){
            int cut1 = low + (high - low)/2;
            int cut2 = leftLength - cut1;

            int left1 = (cut1 == 0)? Integer.MIN_VALUE : nums1[cut1-1];
            int right1 = (cut1 == n)? Integer.MAX_VALUE : nums1[cut1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];
            int right2 = (cut2 == m)? Integer.MAX_VALUE : nums2[cut2];

            if(left1> right2){
                high = cut1-1;
            }else if(left2 > right1){
                low = cut1+1;
            }else{
                int result = Math.max(left1,left2);
                if(total%2==1){
                    return result;
                }
                int rightResult = Math.min(right1,right2);
                return (result+rightResult)/2.0;
            }
        }
        throw new IllegalArgumentException("Wrong parameter");
    }
}
