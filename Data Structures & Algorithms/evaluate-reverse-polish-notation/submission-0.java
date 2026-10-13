class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){
            switch (token){
                case "+":
                case "-":
                case "*":
                case "/":
                    int right = stack.pop();
                    int left = stack.pop();
                    switch (token){
                        case "+": stack.push(left+right); break;
                        case "-": stack.push(left-right); break;
                        case "*": stack.push(left*right); break;
                        case "/": stack.push(left/right); break;
                    }
                    break;
                default: 
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        
    }
}
