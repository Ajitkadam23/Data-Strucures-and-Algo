import java.util.Arrays;
class MyStack<T> { //defined generic class
//	public static void main(String[] args) throws EmptyStackException {
//		 MyStack stk=new MyStack();
////		     stk.top();
//		     stk.push("b");
//		     stk.push("c");
//		     System.out.println(stk.isEmpty());
//		     System.out.println(stk.pop());
//		     System.out.println("poped b");
//		     System.out.println(stk.pop());
//		     System.out.println("popped c");
//		     System.out.println(stk.pop());
//		     System.out.println(stk.isEmpty());
//		   }
private T[] new_array; 
int curr_length=1024;// actual length of the array
int curr_top=0; //index of top element of the stack
MyStack(){
	T[] array;//initialized empty array
	array= (T[]) new Object[curr_length];
	this.new_array=array;
}
public void push(T integer) {
	if(this.curr_top<curr_length) {
		
		this.new_array[curr_top]=integer;
		this.curr_top=this.curr_top+1;
		
	}
	else {//create new array with length increased
		T[] temp_array=(T[]) new Object[curr_length];
		this.curr_length=this.curr_length+1024;
		for(int i=0;i<this.curr_length;i++) {
			temp_array[i]=new_array[i];
			
		}
		
		temp_array[curr_top]=integer;
		this.curr_top=this.curr_top+1;
		this.new_array=temp_array; //updated new stack
		
	}
	
	
}
public boolean isEmpty() {
	return (curr_top==0);
}
public T pop() throws EmptyStackException  {
	if (this.isEmpty()==true) {
	throw new EmptyStackException();
	}
//	else {
//		int x=this.curr_top;
//		this.curr_top=this.curr_top-1;	
//		return this.new_array[x];
//		
//	}
//  if(this.curr_top==0) {
//	 
//  }

  T x=new_array[this.curr_top-1];
  this.curr_top=this.curr_top-1;
  
  return x;
	
}
public T top() throws EmptyStackException {
	if (this.isEmpty()==true) {
		throw new EmptyStackException();
		}
	T x=new_array[this.curr_top-1];
	return x;
}

}
class EmptyStackException extends Exception{}