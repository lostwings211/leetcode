import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (tokens[i]) {
                    case "+":  
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "*" :
                        stack.push(operand1 * operand2);
                        break;
                    default :
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
