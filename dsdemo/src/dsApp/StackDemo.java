package dsApp;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> S = new Stack<>();
		for(int i = 0; i<5; i++){
			//S.push(args);
			S.push(i);
		}
		System.out.println("Bottom-->"+S+"<--Top");
		//S.pop();
		while(!S.isEmpty()){
			System.out.println("After poping "+S.pop());
			System.out.println("Now	Bottom-->"+S+"<--Top");
		}
		
		//System.out.println("After poping "+S.pop());
		//System.out.println("Now	Bottom-->"+S+"<--Top");
	}

}
