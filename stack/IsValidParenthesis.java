class IsValidParenthesis {

	public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                
                char stackTop = stack.pop();
                if(stackTop != map.get(c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();    
    }

}
