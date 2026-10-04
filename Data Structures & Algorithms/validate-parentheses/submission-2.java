class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char r = s.charAt(i);
                char open = st.pop();

                if(
                    r==')' && open !='(' ||
                    r=='}' && open !='{' ||
                    r==']' && open !='['
                ){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
