class cl_string{

    private String str;
    private char ch;

    cl_string(String str_inc){
        str = str_inc;
    }

    void recursive_string(){
        rc_str(str.length() - 1, 0);
        System.out.println();
    }

    void rc_str(int start, int finish){
        if (start == finish)
            return;
        else
        {
            ch = str.charAt(start);
            System.out.print(ch);
            rc_str(start - 1, finish);
        }
    }
}

class StringBackwards{
    public static void main(String args[]){
        cl_string ob = new cl_string("This is going to be printed backwards!");
        ob.recursive_string();
    }
}