package dsApp;

import java.util.Stack;

public class MatchTags {

	/*public int checkRegulation(char c){
		final String opening  = "({[";                // opening delimiters
	    final String closing  = ")}]";                // respective closing delimiters
	    return(opening.indexOf(c));
	}
	
	public static boolean isMatched(String myString){
		Stack<Character> myStack = new Stack<>();
		char tempPop;
		int i = 0;
		for(char c : myString.toCharArray()){
			System.out.println("Step" + ++i);
			if(myStack.isEmpty()){
				myStack.push(c);
				System.out.println("Push "+c+" because stack is empty");
				System.out.println("Bottom-->"+myStack+"<--Top");
			}
			else if(c!=myStack.firstElement()){
				myStack.push(c);//
				System.out.println("Push "+c+" because not match first element in stack");
				System.out.println("Bottom-->"+myStack+"<--Top");
			}
			else{
				tempPop = myStack.pop();
				System.out.println("Pop "+tempPop);
				System.out.println("Bottom-->"+myStack+"<--Top");
			}
			System.out.println("--------------------------");
			
		}
		if(myStack.isEmpty())return true;
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myString1 = "(){}[]";
		//Stack<Character> myStack = buildStack(myString1);
		if(isMatched(myString1))System.out.print("Matched!");
		else System.out.print("Not Matched!");
	}*/
	public static boolean isMatched(String expression) {
	    final String opening  = "({[";                // opening delimiters
	    final String closing  = ")}]";                // respective closing delimiters
	    Stack<Character> buffer = new Stack<>();
	    for (char c : expression.toCharArray()) {
	      if (opening.indexOf(c) != -1)               // this is a left delimiter
	        buffer.push(c);
	      else if (closing.indexOf(c) != -1) {        // this is a right delimiter
	        if (buffer.isEmpty())                     // nothing to match with
	          return false;
	        if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
	          return false;                           // mismatched delimiter
	      }
	    }
	    return buffer.isEmpty();                      // were all opening delimiters matched?
	  }

	  final static String[] valid = {
	    "()(()){([()])}",
	    "( ) ( ( ) ) {( [ ( )  ] ) } ",
	    "(3) (3 + (4 - 5) ) {( [ ( )  ] ) } ",
	    "((()(()){([()])}))",
	    "[(5+x)-(y+z)]"
	  };

	  final static String[] invalid = {
	    ")(()){([()])}",
	    "({[])}",
	    "("
	  };

	  public static void main(String[] args) {

	    for (String s : valid)
	      if (!isMatched(s))
	        System.out.println("Error evaluating valid: " + s);

	    for (String s : invalid)
	      if (isMatched(s))
	        System.out.println("Error evaluating invalid: " + s);

	  }
}
