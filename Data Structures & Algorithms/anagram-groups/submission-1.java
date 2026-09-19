class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            mp.computeIfAbsent(sorted,k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(mp.values());

    }
}
