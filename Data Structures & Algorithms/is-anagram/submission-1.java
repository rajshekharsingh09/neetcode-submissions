class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        if(s.length()!=t.length())return false;

        for(int i =0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            }else{
                mp.put(s.charAt(i),1);
            }
        }
        
        for(int j=0;j<t.length();j++){
            if(mp.containsKey(t.charAt(j))){
                mp.put(t.charAt(j),mp.get(t.charAt(j))-1);
            }else{
                return false;
            }
        }

        for(Map.Entry<Character,Integer> entry: mp.entrySet()){
            if(entry.getValue()>0)return false;
        }
        return true;

    }
}
