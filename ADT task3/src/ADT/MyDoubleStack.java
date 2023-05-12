package ADT;

public class MyDoubleStack {
    private int[] arr; // array to hold the elements of the two stacks
    private int blue; // pointer for the top element of the first stack
    private int red; // pointer for the top element of the second stack

    // constructor to initialize the array and the pointers **** 
    public MyDoubleStack(int capacity) {
        arr = new int[capacity]; // create a new array with the specified capacity
        blue = -1; // set the pointer for the first stack to -1 (empty)
        red = capacity; // set the pointer for the second stack to capacity (empty)
    }

    // push an item onto the first stack
    public void push1(int item) {
        // check whether the first stack has run into the second stack
        if (blue + 1 == red) {
            throw new RuntimeException("error in stack"); // throw an exception if the stack is full
        }
        arr[++blue] = item; // increment the pointer and assign the item to the new top element of the first stack
    }

    // push an item onto the second stack
    public void push2(int item) {
        // check whether the second stack has run into the first stack
        if (red - 1 == blue) {
            throw new RuntimeException("error in stack"); // throw an exception if the stack is full
        }
        arr[--red] = item; // decrement the pointer and assign the item to the new top element of the second stack
    }

    // pop an item from the first stack
    public int pop1() {
        // check whether the first stack is empty
        if (blue == -1) {
            throw new RuntimeException("error in stack"); // throw an exception if the stack is empty
        }
        return arr[blue--]; // return the top element of the first stack and decrement the pointer
    }

    // pop an item from the second stack
    public int pop2() {
        // check whether the second stack is empty
        if (red == arr.length) {
            throw new RuntimeException("error in stack"); // throw an exception if the stack is empty
        }
        return arr[red++]; // return the top element of the second stack and increment the pointer
    }

    // check whether the first stack is empty
    public boolean isEmpty1() {
        return blue == -1;
    }

    // check whether the second stack is empty
    public boolean isEmpty2() {
        return red == arr.length;
    }

    // check whether the first stack is full
    public boolean isFull1() {
        return blue + 1 == red;
    }

    // check whether the second stack is full
    public boolean isFull2() {
        return red - 1 == blue;
    }

    // main method to test the double stack
    public static void main(String[] args) {
        MyDoubleStack stack = new MyDoubleStack(10); // create a new double stack with capacity 10
        stack.push1(1); // push an item onto the first stack
        stack.push2(2); // push an item onto the second stack
        stack.push1(3); // push an item onto the first stack
        stack.push2(4); // push an item onto the second stack
        stack.push1(5);
        stack.push2(6);
        stack.push1(7);
        stack.push2(8);
        System.out.println(stack.pop1()); // pop an item from the first stack and print it
        System.out.println(stack.pop2()); // pop an item from the second stack and print it
        
    }
}
