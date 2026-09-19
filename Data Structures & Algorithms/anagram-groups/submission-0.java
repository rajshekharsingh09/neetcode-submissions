class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(int i =0; i<strs.length;i++){
            String currStr = strs[i];
            char[] chars = currStr.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if(mp.containsKey(sortStr)){
                mp.get(sortStr).add(currStr);
            }else{
                mp.put(sortStr, new LinkedList<>());
                mp.get(sortStr).add(currStr);
            }
        }
        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String,List<String>> entry : mp.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
