class Stack{
    private char arr[];
    private int sp;

    Stack(int size){
        arr = new char[size];
        sp = -1;
    }

    public void push(char c){
        arr[++sp] = c;
    }

    public char pop(){
        return arr[sp--];
    }
}

class Stack1{
    public static void main(String args[]){
        Stack ob = new Stack(100);

        ob.push('c');
        ob.push('k');
        char c;
        c = ob.pop();
        System.out.println("Char from stack is: " + c);
    }
}