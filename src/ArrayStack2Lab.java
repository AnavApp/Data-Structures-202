/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano
    @version 3.0
*/
import java.util.Arrays;
public class ArrayStack2Lab<T> implements StackInterface<T>
{
    public static void main(String[] args)  {
		ArrayStack2Lab<Integer> stack = new ArrayStack2Lab<>();

        System.out.println("Display empty stack:");
        stack.display();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Display stack after pushing 10, 20, 30:");
        stack.display();

        int removed = stack.remove(2);
        System.out.println("Removed " + removed + " elements.");
        System.out.println("Display stack after removing 2 elements:");
        stack.display();

        removed = stack.remove(5);
        System.out.println("Removed " + removed + " elements.");
        System.out.println("Display stack after removing 5 elements:");
        stack.display();
	
	}

    // Problem 1
    public void display() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            for (int i = topIndex; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }

    }

    // Problem 2
    public int remove(int n) {
        int removed = 0;
        while (!isEmpty() && removed < n) {
            pop();
            removed++;
        }
        return removed;
    }

    
   private T[] stack;    // array of stack entries
   private int topIndex; // index of top entry
   private static final int DEFAULT_INITIAL_CAPACITY = 50;
  
   public ArrayStack2Lab()
   {
      this(DEFAULT_INITIAL_CAPACITY);
   } // end default constructor
  
   public ArrayStack2Lab(int initialCapacity)
   {
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
      topIndex = -1;
  } // end constructor
  
   public void push(T newEntry)   
   {  
       ensureCapacity();      
       topIndex++;      
       stack[topIndex] = newEntry;   
   } // end push   
   
   private void ensureCapacity()   
   {      if (topIndex == stack.length - 1) // if array is full, double size of array      
	   stack = Arrays.copyOf(stack, 2 * stack.length);   
   } // end ensureCapacity
   
   public T peek()   
   {  
       T top = null;         
       if (!isEmpty())       
	   top = stack[topIndex];             
       return top;   
   } // end peek
   
   public T pop()
   {
       T top = null;
       
       if (!isEmpty()) {
	   top = stack[topIndex];
	   stack[topIndex] = null;
	   topIndex--; 
       } // end if
       
       return top;
   } // end pop
   
   public boolean isEmpty()
   {   
       return topIndex < 0;
   } // end isEmpty

   public void clear()
   {
       for(int i = 0; i <= topIndex; ++i)
	   stack[i] = null;
       topIndex = -1;
   }
   
} // end ArrayStack2Lab
