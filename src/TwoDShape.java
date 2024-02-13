abstract public class TwoDShape {
    private double width;
    private double height;
    private String name;
    // Стандартный конструктор.
    TwoDShape() {
        width = height = 0.0;
        name = "none";
    }
    // Параметризованный конструктор.
    TwoDShape(double w, double h, String n) {
        width = w;
        height = h;
        name = n;
    }
    // Конструктор объекта с одинаковыми шириной и высотой.
    TwoDShape(double x, String n) {
        width = height = x;
        name = n;
    }
    // Конструктор объекта из объекта.
    TwoDShape(TwoDShape ob) {
        width = ob.width;
        height = ob.height;
        name = ob.name;
    }
    // Методы доступа для width и height,
    double getWidth() { return width; }
    double getHeight() { return height; }
    void setWidth(double w) { width = w; }
    void setHeight(double h) { height = h; }
    String getName() { return name; }
    void showDim() {
        System.out.println("Ширина и высота: " + width + " и " + height);
    }
    // Теперь метод агеа() абстрактный,
    abstract double area();
}

// Подкласс TwoDShape для представления треугольников,
class Triangle extends TwoDShape {
    private String style;
    // Стандартный конструктор.
    Triangle() {
        super();
        style = "отсутствует";
    }

    // Конструктор класса Triangle.
    Triangle(String s, double w, double h) {
        super(w, h, "треугольник");
        style = s;
    }
    // Конструктор с одним аргументом.
    Triangle(double x) {
        super(x, "треугольник");
        style = "закрашенный";
// вызов конструктора суперкласса
    }
    // Конструктор объекта из объекта.
    Triangle(Triangle ob) {
        super(ob); // передача объекта конструктору класса TwoDShape
        style = ob.style;
    }

    @Override
    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Стиль треугольника: " + style);
    }
}

// Подкласс TwoDShape для представления прямоугольников,
class Rectangle extends TwoDShape {
    // Стандартный конструктор.
    Rectangle() {
        super();
    }

    // Конструктор класса Rectangle.
    Rectangle(double w, double h) {
        super(w, h, "прямоугольник"); // вызов конструктора суперкласса
    }

    // Конструктор квадрата.
    Rectangle(double х) {
        super(х, "прямоугольник"); // вызов конструктора суперкласса
    }

    // Конструктор объекта из объекта.
    Rectangle(Rectangle ob) {
        super(ob); // передача объекта конструктору класса TwoDShape
    }

    boolean isSquare() {
        if (getWidth() == getHeight()) return true;
        return false;
    }

    @Override
    double area() {
        return getWidth() * getHeight() ;
    }
}

class Circle extends TwoDShape {

    Circle(double radius) {
        super(radius, "Круг");
    }

    @Override
    double area() {
        return 3.14*(getWidth()*getWidth());
    }
}

class AbsShape {
    public static void main(String[] args) {
        TwoDShape[] shapes = new TwoDShape[5];
        shapes[0] = new Triangle("контурный", 8.0, 12.0);
        shapes[1] = new Rectangle(10);
        shapes[2] = new Rectangle(10, 4);
        shapes[3] = new Triangle(7.0);
        shapes[4] = new Circle(2.4);

        for(int i=0; i < shapes.length; i++) {
            System.out.println("Объект с именем: " + shapes[i].getName());
            System.out.println("Площадь: " + shapes[i].area());
            System.out.println();
        }
    }
}