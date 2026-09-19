class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String st: strs){
            sb= sb.append(st.length()).append('#').append(st);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> st = new ArrayList<>();
        for(int i = 0; i < str.length(); ){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int stLength = Integer.parseInt(str.substring(i,j));
            int start = j+1;
            int end = start+stLength;
            st.add(str.substring(start,end));
            i = end;
        }
        return st;
    }
}
