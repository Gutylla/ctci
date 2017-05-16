/**
 * 
 */
package LeetCodeProblems;

import java.util.Stack;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class RevPolishNotation {

	public int evalRPN(String[] tokens) {
		if(tokens.length == 0) return 0;

		Stack<String> stack = new Stack<String>();

		for(String token: tokens){
			if(token == "+" || token == "-" || token == "*" || token == "/")
				stack.push(calc(stack.pop(), stack.pop(), token));
			else
				stack.push(token);
		}

		return Integer.parseInt(stack.pop());
	}

	private String calc(String var1, String var2, String operator){
		switch(operator){
		case "+":
			return String.valueOf(Integer.parseInt(var2) + Integer.parseInt(var1));
		case "-":
			return String.valueOf(Integer.parseInt(var2) - Integer.parseInt(var1));
		case "*":
			return String.valueOf(Integer.parseInt(var2) * Integer.parseInt(var1));
		case "/":
			return String.valueOf(Integer.parseInt(var2) / Integer.parseInt(var1));
		default:
			return "";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"18"};
		RevPolishNotation obj = new RevPolishNotation();
		System.out.println(obj.evalRPN(tokens));
	}

}
