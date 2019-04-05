class Outer{
    int nums[];

    Outer(int n[]){
        nums = n;
    }

    void analyze(){
        Inner inOb = new Inner();

        System.out.println("Minimum: " + inOb.min());
        System.out.println("Maximum: " + inOb.max());
        System.out.println("Average: " + inOb.avg());
    }

    class Inner{
        int min(){
            int m = nums[0];

            for (int i = 1; i < nums.length; i++)
                if (m > nums[i]) m = nums[i];
            return m;
        }

        int max(){
            int m = nums[0];

            for (int i = 1; i < nums.length; i++)
                if (m < nums[i]) m = nums[i];
            return m;
        }

        int avg(){
            int sum = 0;

            for(int i = 0; i < nums.length; i++)
                sum += nums[i];
            return sum / nums.length;
        }

    }
}

class NestedClassDemo{
    public static void main(String args[]){
        int x[] = {0, 15, 13, 99, 12312, 987, 17, 123, 321, 111, 222, 777, -15};
        Outer Outob = new Outer(x);

        Outob.analyze();
    }
}