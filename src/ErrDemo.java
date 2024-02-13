
// Демонстрация перегрузки конструкторов,
class MyClass1 {
    int x;
    MyClass1() {
        System.out.println("Внутри MyClass().");
        x = 0;
    }

    MyClass1(int i) {
        System.out.println("Внутри MyClass(int).");
        x = i;
    }
    MyClass1(double d) {
        System.out.println("Внутри MyClass(double).");
        x = (int) d;
    }
    MyClass1(int i, int j) {
        System.out.println("Внутри MyClass(int, int).");
        x = i * j;
    }
}

class OverloadConsDemo {
    public static void main(String[] args) {
        MyClass1 tl = new MyClass1();
        MyClass1 t2 = new MyClass1(88);
        MyClass1 t3 = new MyClass1(17.23);
        MyClass1 t4 = new MyClass1( 2, 4);
        var t5=new MyClass1();
        System.out.println("tl.x: " + tl.x);
        System.out.println("t2.x: " + t2.x);
        System.out.println("t3.x: " + t3.x);
        System.out.println("t4.x: " + t4.x);
    }
}


class Overload2 {
    void f(int x) {
        System.out.println("Внутри f(int): " + x);
    }
    void f(double x) {
        System.out.println("Внутри f(double): " + x);
    }
}
class TypeConv {
    public static void main(String[] args) {
        Overload2 ob = new Overload2();
        int i = 10;
        double d = 10.1;
        byte b = 99;
        short s = 10;
        float f = 11.5F;
        ob.f(i);
        ob.f(d);
        ob.f(b);
        ob.f(s);
        ob.f(f);
        System.out.println();
    }
}




class Overload {
    void ovlDemo() {
        System.out.println("Без параметров");
    }
    // Перегруженная версия ovlDemo с одним параметром типа int.
    void ovlDemo(int a) {
        System.out.println("Один параметр типа int: " + a);
    }
    // Перегруженная версия ovlDemo с двумя параметрами типа int.
    int ovlDemo(int a, int b) {
        System.out.println("Два параметра типа int: " + a + " " + b);
        return a + b;
    }
    // Перегруженная версия ovlDemo с двумя параметрами типа double,
    double ovlDemo(double a, double b) {
        System.out.println("Два параметра типа double: " + a + " " + b);
        return a + b;
    }
}

class OverloadDemo {
    public static void main(String[] args) {
        Overload ob = new Overload();
        int resl;
        double resD;
// Вызвать все версии ovlDemo().
        ob.ovlDemo();
        System.out.println();
        ob.ovlDemo(2);
        System.out.println();
        resl = ob.ovlDemo(4, 6);
        System.out.println("Результат вызова ob.ovlDemo(4, 6): " + resl);
        System.out.println();
        resD = ob.ovlDemo(1.1, 2.32);
        System.out.println("Результат вызова ob.ovlDemo(1.1, 2.32): " + resD);
    }
}

//Класс Err
class Err {
    String msg;
    int severity;

    //Конструктор
    Err(String m, int s) {
        msg = m;
        severity = s;
    }
}

//Класс ErrorInfo
class Errorlnfo {
    String[] msgs = {
            "Ошибка вывода",
            "Ошибка ввода",
            "Диск переполнен",
            "Индекс вышел за границы "
    };
    int[] howBad = { 3, 3, 2, 4 };

    // Метод
    Err getErrorlnfo(int i) {
        if(i >= 0 & i < msgs.length)
        return new Err(msgs[i], howBad[i]);
    else
        return new Err("Несуществующий код ошибки", 0);
    }
}

//Программа
class Errlnfo {
    public static void main(String[] args) {
        Errorlnfo err = new Errorlnfo();
        Err e;
        e = err.getErrorlnfo(2);
        System.out.println(e.msg + ", уровень серьезности; " + e.severity);
        e = err.getErrorlnfo(19);
        System.out.println(e.msg + ", уровень серьезности: " + e.severity);
    }
}

// Возвращение объекта типа String,
class ErrorMsg {
    // Коды ошибок,
    final int OUTERR = 0;
    final int INERR = 1;
    final int DISKERR = 2;
    final int INDEXERR = 3;
    String[] msgs = {
            "Ошибка вывода",
            "Ошибка ввода",
            "Диск переполнен",
            "Индекс вышел за границы "
    } ;
    // Возвратить сообщение об ошибке.
    String getErrorMsg(int i) {
        if(i >=0 & i < msgs.length)
            return msgs[i];
        else
            return "Несуществующий код ошибки";
    }
}

class FinalD {
    public static void main(String[] args) {
        ErrorMsg err = new ErrorMsg();
        System.out.println(err.getErrorMsg(err.OUTERR));
        System.out.println(err.getErrorMsg(err.DISKERR));
    }
}

/*
Для показанного ниже класса напишите метод по имени swap ( ) , который
меняет местами содержимое двух объектов типа Test:
class Test {
int a;
Test(int i) { a = i; }
}
 */

class Test {
    int a;
    Test(int i) {
        a = i;
    }


    static void swap(Test t1, Test t2) {
        int i=t1.a;
        t1.a=t2.a;
        t2.a=i;
    }
}

class TestDem{
    public static void main(String[] args) {
        Test tk1=new Test(3);
        Test tk2=new Test(5);
        Test.swap(tk1,tk2);
        System.out.println();
    }
}