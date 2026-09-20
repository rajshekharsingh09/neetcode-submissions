class Solution {
    public boolean isPalindrome(String s) {

        char[] chars = s.toLowerCase().toCharArray();
        System.out.println(chars);

        StringBuilder sb = new StringBuilder();
        
        for(int l=0;l<s.length();l++){
            if((chars[l]>='a' && chars[l]<='z') || (chars[l]>='0' && chars[l]<='9')){
               sb = sb.append(chars[l]);
            }
            
        }

        char[] filteredChars = sb.toString().toCharArray();
        System.out.println(" filtered value  => ["+sb.toString()+"]");

        int i=0;
        int j=filteredChars.length-1;
        while(i<j  && i<filteredChars.length-1 && j>0 && filteredChars[i]==filteredChars[j]){
                i++;
                j--;
        }
        if(i<j)return false;
        return true;
        
    }
}
