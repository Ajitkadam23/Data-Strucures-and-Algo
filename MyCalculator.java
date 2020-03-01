//package A_2;

import java.util.Arrays;

public class MyCalculator extends MyStack {
//	public static void main(String args[]) throws EmptyStackException {
//		MyCalculator clc=new MyCalculator();
//		String[] string=new String[1];
//		string[0]= "4*2+2*(2+9)";
//		clc.calculate(string[0]);
//		
//	}
	private MyStack<String> stack;
	public MyCalculator() {
		MyStack stack=new MyStack();//used class MyStack to create new Stack
		this.stack=stack;
		
		
		
	}
   public int calculate(String expression) throws EmptyStackException {
	   String[] st=expression.split("");
	   
	   MyStack<String> temp_stack=new MyStack(); 
	   for(int i=0;i<st.length;i++) {
                    if(st[i].equals(" ")) {
			   continue;
		   }
		   if(temp_stack.isEmpty()==true) {
			   temp_stack.push(st[i]);
		   }
		   else {
			   if(st[i].equals("+")||st[i].equals("-")||st[i].equals("*")||st[i].equals("(")||st[i].equals(")")) {
				   temp_stack.push(st[i]);
			   }
			   else {
				   if(temp_stack.top().equals("+")||temp_stack.top().equals("-")||temp_stack.top().equals("*")||temp_stack.top().equals("(")||temp_stack.top().equals(")")){
					   temp_stack.push(st[i]);
				   }
				   else {
					   String c=temp_stack.pop()+st[i];
					   temp_stack.push(c);
				   }
			   }
		   }
	   }
//	   System.out.println(temp_stack.curr_top);
	   int top=temp_stack.curr_top-1;
	   String[] temp_array=new String[temp_stack.curr_top];
	   while(temp_stack.isEmpty()==false) {
		   temp_array[top]=temp_stack.pop();
		   top=top-1;

	   }
//	   System.out.println(temp_array[1]);
//	   for (int i=0;i<temp_array.length;i++) {
//	
//		   System.out.println(temp_array[i]);
//	   }
	   
	   MyStack<String> operator_stack=new MyStack(); 
	   MyStack<String> postfix_stack=new MyStack(); 
	   
	   for(int i=0;i<temp_array.length;i++) {
		   
		   if (!temp_array[i].equals("(") && !temp_array[i].equals(")")&& !temp_array[i].equals("+") &&!temp_array[i].equals("-") && !temp_array[i].equals("*")) {
			   postfix_stack.push(temp_array[i]);
		   }
		   else if (temp_array[i].equals("*")) {
			   while(operator_stack.isEmpty()==false && !operator_stack.top().equals("(")&&operator_stack.top().equals("*")) {
			   postfix_stack.push(operator_stack.pop());
		   }
			   operator_stack.push("*");
		   }
		   else if (temp_array[i].equals("+") ||temp_array[i].contentEquals("-")) {
			   while(operator_stack.isEmpty()==false && !operator_stack.top().equals("(")) {
				   postfix_stack.push(operator_stack.pop());
			   }
			   operator_stack.push(temp_array[i]);
		   }
		   else if (temp_array[i].equals("(")) {
			   operator_stack.push("(");
		   }
		   else {
			   while(operator_stack.isEmpty()==false && !operator_stack.top().equals("(")) {
				   postfix_stack.push(operator_stack.pop());
			   }
			   operator_stack.pop();
		   }
		 
	   }
	   while(operator_stack.isEmpty()==false) {
		   postfix_stack.push(operator_stack.pop());
	   }
	   
//	   while(postfix_stack.isEmpty()==false) {
//		   System.out.println(postfix_stack.pop());
//	   }
	   String[] new_string=new String[postfix_stack.curr_top];
	   int top1=postfix_stack.curr_top-1;
	   while(postfix_stack.isEmpty()==false) {
		   new_string[top1]=postfix_stack.pop();
		   top1=top1-1;
	   }
	   
	   
	   MyStack<Integer> post_evalution=new MyStack();
	   for (int i=0;i<new_string.length;i++) {
//		   System.out.println(new_string[i]+new_string[i].equals("+"));
		   if(new_string[i].equals("+")) {
			   post_evalution.push(post_evalution.pop()+post_evalution.pop());
		   }
		   else if(new_string[i].equals("-")) {
			   post_evalution.push(-post_evalution.pop()+post_evalution.pop());
		   }
		   else if(new_string[i].equals("*")) {
			   post_evalution.push(post_evalution.pop()*post_evalution.pop());
		   }
		   else {
//			   System.out.println("here"+new_string[i]);
			   int pp=Integer.parseInt(new_string[i]);
			   post_evalution.push(pp);
		   }
	   }
	   
	 int xx=post_evalution.pop();
//	 System.out.println(xx);
	return xx;
	 		    

   }
}
	      

   