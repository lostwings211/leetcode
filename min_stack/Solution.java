import java.util.*;
class MinStack {
    private ArrayList<Integer> stack = new ArrayList<Integer>();
    private ArrayList<Integer> min_stack = new ArrayList<Integer>();
    
    public void push(int x) {
        stack.add(x);
        if(min_stack.size() == 0) {
            min_stack.add(x);
        }
        else {
            if(x <= min_stack.get(min_stack.size() -1)) {
                min_stack.add(x);
            }
        }
    }

    public void pop() {
        int curr = stack.get(stack.size() - 1);
        if(curr == min_stack.get(min_stack.size() -1)) {
            min_stack.remove(min_stack.size() - 1);
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min_stack.get(min_stack.size() -1);
    }
}

