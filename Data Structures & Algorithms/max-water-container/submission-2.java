class Solution {
    public int maxArea(int[] heights) {
        int container=0;
        int left =0;
        int right=heights.length-1;

        while(left<right){
            int h = Math.min(heights[left],heights[right]);
            int area= (right-left)*h;
            container = Math.max(container,area);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return container;
        
    }
}
