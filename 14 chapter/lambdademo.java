interface MyValue{
    double getValue();
}

interface MyParamValue{
    double getValue(double v);
}

class lambdademo{
    public static void main(String args[]){
        MyValue myVal;

        // Here, the lambda expression is simply a constant expression. 
        // When it is assigned to myVal, a class instance is 
        // constructed in which the lambda expression implements 
        // the getValue() method in MyValue. 

        myVal = ()->98.6;
        System.out.println("A constant value: " + myVal.getValue()); 

        // Now, create a parameterized lambda expression and assign it to 
        // a MyParamValue reference. This lambda expression returns 
        // the reciprocal of its argument. 
        MyParamValue myPval = (n)-> 1.0 / n;
        System.out.println("Reciprocal of 4 is " + myPval.getValue(4.0)); 
        System.out.println("Reciprocal of 8 is " + myPval.getValue(8.0)); 

        // A lambda expression must be compatible with the method 
        // defined by the functional interface. Therefore, these won't work: 
        //  myVal = () -> "three"; // Error! String not compatible with double! 
        //  myPval = () -> Math.random(); // Error! Parameter required! 
    }
}