class Stack{
    private char arr[];
    private int sp;

    Stack(int size){
        arr = new char[size];
        sp = -1;
    }

    public void push(char c) throws StackFullException{
        if (sp + 1 == arr.length)
            throw new StackFullException();
        arr[++sp] = c;
    }

    public char pop() throws StackEmptyException{
        if (sp == -1)
            throw new StackEmptyException();
        return arr[sp--];
    }
}

class Stack1{
    public static void main(String args[]){
        Stack ob = new Stack(3);

        for (int i = 0; i < 4; i++){
            try{
                ob.push((char)('A' + i));
                System.out.println("Pushed in stack: " + ((char)('A' + i)) );
            }
            catch (StackFullException e){
                System.out.println(e);
            }
        }
        for (int i = 0; i < 4; i++){
            try{
                System.out.println("Poped out of stack: " + ob.pop());
            }
            catch (StackEmptyException e){
                System.out.println(e);
            }
        }
    }
}