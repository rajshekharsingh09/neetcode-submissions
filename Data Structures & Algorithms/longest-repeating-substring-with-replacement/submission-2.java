class Solution {
    public int characterReplacement(String s, int k) {

        int left =0;
        int maxFreq=0;
        int[] freq = new int[26];
        int maxLength =0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(right)-'A']);
            while(right-left-maxFreq +1 > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }

        return maxLength;
    }
}
