package chap19.brackets2;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/*
https://algospot.com/judge/problem/read/BRACKETS2
 */
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while(cases-- > 0) {
	    	/**		input		*/
			String fomular = sc.next();			

        	/**		output		*/
			if(wellMatched(fomular))
				System.out.println("YES");
			else
				System.out.println("NO");
		}				
	}
	
	public static boolean wellMatched(String fomular) {
		Stack<String> stack = new Stack<>();
		for(int i=0;i<fomular.length();i++) {
			char ch = fomular.charAt(i);
			if(ch=='{' || ch=='[' || ch=='(') {
				stack.push(String.valueOf(ch));
			} else {
				//스택이 비어있는 경우
				if(stack.isEmpty()){ 
					return false;
				}				
				String head = stack.pop();
				if(!isMatch(ch,head)) {
					return false;
				}
			}
		}
		return stack.isEmpty(); //닫히지 않는 괄호가 없어야 성공
	}
		
	public static boolean isMatch(char ch,String head) {
		switch(ch) {
		case '}' :
			return head.equals("{");
		case ']' :
			return head.equals("[");
		case ')' :			
			return head.equals("(");
		}
		return false;
	}
	
	public static boolean wellMatched2(String input) {
		Stack<Character> stack = new Stack<>();
    	for(int i=0;i<input.length();i++) {
    		char ch = input.charAt(i);
    		switch(ch) {
    			case '(':    				
    			case '{':
    			case '[':
    				stack.push(ch);
    				break;
    			case ']':
    				if(stack.isEmpty() || stack.pop() != '[')
    					return false;
    				break;
    			case '}':
    				if(stack.isEmpty() || stack.pop() != '{')
    					return false;
    				break;
    			case ')':
    				if(stack.isEmpty() || stack.pop() != '(')
    					return false;
    				break;
    		}	
    	}
    	
    	return stack.isEmpty();
	}
	
}


/*
3
()()
({[}])
({}[(){}])
*/