class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int j =0;
        Map<Character,Boolean> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            while(mp.containsKey(s.charAt(i))){
                mp.remove(s.charAt(j));
                j++;
            }
            mp.put(s.charAt(i),true);
            
            maxLength=Math.max(maxLength,i-j+1);
        }

        return maxLength;
    }
}