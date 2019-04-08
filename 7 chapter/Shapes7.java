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

class Shapes7{
    public static void main(String args[]){
        Triangle t1 = new Triangle("outlined", 8.0, 12.0);
        Triangle t2 = new Triangle(t1);

        System.out.println("T1 stats: ");
        t1.showShapes7();
        System.out.println("\n T2 stats: ");
        t2.showShapes7();
    }
}