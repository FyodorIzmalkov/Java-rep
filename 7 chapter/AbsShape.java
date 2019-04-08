abstract class TwoDShape{
    private double width;
    private double height;
    private String name;

    TwoDShape(){
        width = height = 0.0;
        name = "none";
    }

    TwoDShape(double w, double h, String n){
        width = w;
        height = h;
        name = n;
    }

    TwoDShape(double x, String n){
        width = height = x;
        name = n;
    }

    TwoDShape(TwoDShape ob){
        width = ob.width;
        height = ob.height;
        name = ob.name;
    }

    double getWidth(){
        return width;
    }
    double getHeight(){
        return height;
    }
    void setWidth(double w){
        width = w;
    }
    void setHeight(double h){
        height = h;
    }
    String getName(){return name;}

    void showDim(){
        System.out.println("Width and height are " + width + " and " + height); 
    }

    abstract double area();
}

class Triangle extends TwoDShape{
    private String style;

    Triangle(){
        super();
        style = "None";
    }

    Triangle(String s, double w, double h){
        super(w,h, "Triangle");
        style = s;
    }

    Triangle (double x){
        super(x, "Triangle");
        style = "filled";
    }

    Triangle (Triangle ob){
        super(ob);
        style = ob.style;
    }

    double area(){
        return getWidth() * getHeight() / 2;
    }

    void showStyle(){
        System.out.println("Triangle is " + style); 
    }

    void showShapes7(){
        this.showStyle();
        this.showDim();
        System.out.println("Area is : " + this.area());
    }
}

class Rectangle extends TwoDShape{
    Rectangle(){
        super();
    }
    Rectangle(double w, double h){
        super(w,h,"Rectangle");
    }
    Rectangle(double x){
        super(x, "rectangle");
    }
    Rectangle(Rectangle ob){
        super(ob);
    }

    boolean isSquare(){
        if (getWidth() == getHeight()) return true;
        return false;
    }

    double area(){
        return getWidth() * getHeight();
    }
}
class AbsShape{
    public static void main(String args[]){
        TwoDShape shapes[] = new TwoDShape[4];

        shapes[0] = new Triangle("outlined", 8.0, 12.0); 
        shapes[1] = new Rectangle(10); 
        shapes[2] = new Rectangle(10, 4); 
        shapes[3] = new Triangle(7.0); 

        for (int i = 0; i < shapes.length; i++){
            System.out.println("object is " + shapes[i].getName());
            System.out.println("Area is " + shapes[i].area());
            System.out.println(); 
        }
    }
}