class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> st = new HashSet<>();
        for(int i:nums){
            st.add(i);
        }
        int length=0;

        for(int num : st){
            if(!st.contains(num-1)){
                int current = num;
                int curcount = 1;

                while(st.contains(num+1)){
                    num++;
                    curcount++;
                }

                length = Math.max(curcount,length);

            }
        }
        return length;
    }
}
