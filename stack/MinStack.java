public class MinStack {

    private Stack<Integer> minStack; // for saving minValue
    private Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack();
        stack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
        
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        int topElement = stack.pop();
        if(topElement == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}