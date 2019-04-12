import qpack.*;

class IQDemo{
    public static void main(String args[]){
        FixedQueue q1 = new FixedQueue(10);
        DynQueue q2 = new DynQueue(5);
        CircularQueue q3 = new CircularQueue(10);

        ICharQ iQ;
        char ch;
        int i;

        iQ = q1;
        for (i = 0; i < 10; i++)
            iQ.put((char) ('A' + i));

        System.out.println("Content of fixed queue: ");
        for (i = 0; i < 10; i++){
            System.out.print(iQ.get());
        }

        System.out.println();
        iQ = q2;
        for (i = 0; i < 10; i++){
            iQ.put((char)('Z' - i));
        }

        System.out.println("Contents of dynamic queue: ");
        for (i = 0; i < 10; i++){
            System.out.print(iQ.get());
        }
        System.out.println();

        iQ = q3;
        for (i = 0; i < 10; i++){
            iQ.put((char)('A' + i));
        }
        System.out.println("Contents of cirular queue: ");
        for (i = 0; i < 10; i++){
            System.out.print(iQ.get());
        }

        System.out.println("\nStore and consume from circular queue.");
        for (i = 0; i < 20; i++){
            iQ.put((char) ('A' + i));
            System.out.print(iQ.get());
        }

    System.out.println("\nReseted the q3: ");
        iQ.reset();
        for (i = 0; i < 5; i++){
            System.out.print(iQ.get());
        }
    }
}