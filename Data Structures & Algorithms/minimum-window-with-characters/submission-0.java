class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length() || t.isEmpty()){
            return "";
        }

        Map<Character,Integer> mp = new HashMap<>();
        for(char ch: t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        int left =0;
        int missing=t.length();

        int start =0;
        int minLength = Integer.MAX_VALUE;

        for(int right =0;right<s.length();right++){
            char incoming = s.charAt(right);
            if(mp.containsKey(incoming)){
                if (mp.get(incoming) > 0) {
                    missing--;
                }
                mp.put(incoming,mp.get(incoming)-1);
            }

            while(missing==0){
                int windowLength = right-left+1;
                if(windowLength < minLength){
                    minLength = windowLength;
                    start = left;
                }
                char outgoing = s.charAt(left);

                if(mp.containsKey(outgoing)){
                    mp.put(outgoing,mp.get(outgoing)+1);
                    if(mp.get(outgoing)>0){
                        missing++;
                    }
                }
                left++;
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start,start+minLength);
    }
}
