class TwoDShape{
    private double width;
    private double height;

    TwoDShape(){
        width = height = 0.0;
    }

    TwoDShape(double w, double h){
        width = w;
        height = h;
    }

    TwoDShape(double x){
        width = height = x;
    }

    TwoDShape(TwoDShape ob){
        width = ob.width;
        height = ob.height;
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
    void showDim(){
        System.out.println("Width and height are " + width + " and " + height); 
    }
}

class Triangle extends TwoDShape{
    private String style;

    Triangle(){
        super();
        style = "None";
    }

    Triangle(String s, double w, double h){
        super(w,h);
        style = s;
    }

    Triangle (double x){
        super(x);
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

class ColorTriangle extends Triangle{
    private String color;

    ColorTriangle(String c, String s, double w, double h){
        super(s, w, h);

        color = c;
    }

    String getColor(){
        return color;
    }

    void showColor(){
        System.out.println("Color is " + color);
    }

    void showShapes6(){
        this.showStyle();
        this.showDim();
        this.showColor();
        System.out.println("Area is : " + this.area());
    }
}

class Circle extends TwoDShape{

    int radius;

    Circle(int r){
        super();
        radius = r;
    }  

    double area(){
        return 3.14 * radius * radius;
    }
}

class Shapes8{
    public static void main(String args[]){
        Circle circ = new Circle(10);
        System.out.println("Area of a circle is: " + circ.area());
    }
}