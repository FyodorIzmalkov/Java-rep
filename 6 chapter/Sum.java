class Sum_it{

    public int sum(int ... v){
        int i;
        int sum = 0;

        for (i = 0; i < v.length; i++)
            sum += v[i];

        return sum;
    }
}

class Sum{
    public static void main(String args[]){
        Sum_it ob = new Sum_it();

        System.out.println("Sum of 1 2 3 4 5: " + ob.sum(1,2,3,4,5));
    }
}