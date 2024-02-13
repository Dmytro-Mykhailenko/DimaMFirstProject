/*
Упражнение 5.2.
Класс очереди для символов.
*/
import java.util.Scanner;

class Queue {
    char[] q;
    int nextFilled, nextFree, freeSlotsN, putloc, getloc;
    char k=0;


    //        Конструкторы
    Queue(int size) {
        q = new char[size];
        freeSlotsN=size;
        putloc=getloc=nextFilled = nextFree =0;
    }

    // Конструирует объект Queue на основе объекта Queue.
    Queue(Queue ob) {
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];
    // Копировать элементы .
        for(int i=getloc; i < putloc; i++)
            q[i] = ob.q[i];
    }

    // Конструирует объект Queue с начальными значениями.
    Queue(char[] a) {
        putloc = 0;
        getloc = 0;
        q = new char[a.length];
        for(int i = 0; i < a.length; i++)
            put(a[i]);
    }

    //      Методы
    // Поместить символ в очередь, управляет nextFilled
    void puts(char ch) {
        if (freeSlotsN == 0) {
            System.out.println("\nNo free slots");
            return;
        } else if (nextFree == q.length)
            nextFree = 0;

        q[nextFree++]=ch;
        freeSlotsN--;
    }

    // Извлечь символ из очереди, управляет nextFree
    char gets() {
        if (freeSlotsN == q.length) {
            System.out.println("\nNo data");
            return 0;
        } else if (nextFilled == q.length)
            nextFilled =0;

        freeSlotsN++;
        return q[nextFilled++];
    }

    // Поместить символ в очередь,
    void put(char ch) {
        if(putloc==q.length) {
            System.out.println(" - Очередь переполнена.");
            return;
        }
        q[putloc++] = ch;
    }
    // Извлечь символ из очереди,
    char get() {
        if(getloc == putloc) {
            System.out.println(" - Очередь пуста.");
            return (char) 0;
        }
        return q[getloc++];
    }
}

// Демонстрация использования класса Queue,
class QDemo {
    public static void main(String[] args)
            throws java.io.IOException {



        char ch=0 ;
        int code ;
        while ( -1 != (code = System.in.read ()) )
        {
            ch = (char) code ;
            System.out.println ( "you pressed: '" + ch + "'\n" ) ;

            // выйти когда нажато 'q'
            if ( 'q' == ch )
            {
                System.exit ( 0 ) ;
            }
        }

        Queue bigQ = new Queue(10);
        Queue smallQ = new Queue(4);
        //char ch='0', ignore;
        int i;
        String str;
        Scanner inp=new Scanner(System.in);
        str=System.in.toString();
        System.out.println(str);
        KeyPressExample exempl=new KeyPressExample();

        do {
            ch= (char) System.in.read();
            if (ch=='\n') break;
            bigQ.puts(ch);
        } while (bigQ.freeSlotsN!=0);

        System.out.println("Использование bigQ для сохранения алфавита.");
// Поместить в bigQ коды букв,
        for(i=0; i < 10; i++)
            bigQ.puts((char) ('A' + i));
// Извлечь и отобразить элементы bigQ.
        System.out.print("Содержимое bigQ: ");
        for(i=0; i < 10; i++) {
            ch = bigQ.gets() ;
            if(ch != (char) 0) System.out.print(ch);
        }

        System.out.println("\n");
        System.out.println("Использование smallQ для генерации ошибок.");
// Использовать smallQ для генерации ошибок.
        for(i=0; i < 5; i++) {
            System.out.print("Попытка сохранения " + (char) ('Z' - i)) ;
            smallQ.puts((char) ('Z'-i));
            System.out.println();

        }
        System.out.println();
// Дополнительные ошибки в smallQ.
        System.out.print("Содержимое smallQ: ");
        for(i=0; i < 5; i++) {
            ch = smallQ.gets();
            if(ch != (char) 0) System.out.print(ch);
        }
    }
}

/*
Дополнением очереди является стек с доступом к элементам по принципу
“первым пришел — последним обслужен”, который похож на стопку тарелок на столе —
нижняя тарелка используется последней. Создайте класс
стека по имени Stack, который способен хранить символы. Назовите методы для доступа к стеку push ( ) и pop ( ) .
Предоставьте пользователю возможность указания размера стека при его создании. Все остальные члены
класса Stack сделайте закрытыми. (Подсказка: в качестве образца можете
использовать класс Queue; просто измените способ доступа к данным.)
 */

class Stack {
    private char[] q;
    private int loc; // индексы для позиций помещения и извлечения
    Stack(int size) {
        q = new char[size]; // выделение памяти под очередь
        loc = 0;
    }
    // Поместить символ в очередь,
    void push(char ch) {
        if(loc==q.length) {
            System.out.println(" - Достигнут конец стека.");
            return;
        }
        q[loc++]=ch;
    }
    // Извлечь символ из очереди,
    char pop() {
        if(loc == 0) {
            System.out.println(" - Достигнуто начало стека.");
            return (char) 0;
        }
        return q[--loc];
    }
}

class QDemo1 {
    public static void main(String[] args) {
        Stack bigQ = new Stack(10);
        Stack smallQ = new Stack(4);
        char ch;
        int i;
        System.out.print("Использование bigQ для сохранения алфавита. ");
// Поместить в bigQ коды букв,
        for (i = 0; i < 10; i++)
        {bigQ.push((char) ('A' + i));
        System.out.print((char) ('A' + i));}
        System.out.println();
// Извлечь и отобразить элементы bigQ.
        System.out.print("Содержимое bigQ: ");
        for (i = 0; i < 10; i++) {
            ch = bigQ.pop();
            if (ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");
        System.out.println("Использование smallQ для генерации ошибок.");
// Использовать smallQ для генерации ошибок.
        for (i = 0; i < 5; i++) {
            System.out.print("Попытка сохранения " + (char) ('Z' - i));
            smallQ.push((char) ('Z' - i));
            System.out.println();
        }
        System.out.println();


// Дополнительные ошибки в smallQ.
        System.out.print("Содержимое smallQ: ");
        for(i=0; i < 5; i++) {
            ch = smallQ.pop();
            if(ch != (char) 0) System.out.print(ch);
        }
        System.out.println();
    }
}

// Демонстрация использования класса Queue,
class QDemo2 {
    public static void main(String[] args) {
// Создать пустую очередь из 10 элементов.
        Queue ql = new Queue(10);
        char[] name = {'Т', 'o', 'm'};
// Создать очередь из массива.
        Queue q2 = new Queue(name);
        char ch;
        int i;
// Поместить ряд символов в ql.
        for(i=0; i < 10; i++)
            ql.put((char) ('A' + i));
// Создать очередь из другой очереди.
        Queue q3 = new Queue(ql);
// Отобразить содержимое очередей.
        System.out.print("Содержимое q1: ");
        for(i=0; i < 10; i++) {
            ch = ql.get();
            System.out.print(ch);
        }
        System.out.println("\n");
        System.out.print("Содержимое q2: ");
        for(i=0; i < 3; i++) {
            ch = q2.get();
            System.out.print(ch);
        }
        System.out.println("\n");
        System.out.print("Содержимое q3: ");
        for(i=0; i < 10; i++) {
            ch = q3.get();
            System.out.print(ch);
        }
    }
}


/*
Попробуйте самостоятельно изменить класс Queue так,
чтобы он мог хранить объекты других типов, скажем, int или double

В циклической очереди после удаления элементов позиции во внутреннем массиве используются повторно,
а в нециклической очереди
так не происходит и пространство в конечном итоге исчерпывается.
Ради простоты в примере создается нециклическая очередь,
но вы можете легко преобразовать ее в циклическую очередь,
чуть подумав и приложив небольшие усилия


 */

// Использование статического метода,
class StaticMeth {
    static int val = 1024; // статическая переменная
    // статический метод
    static int valDiv2() {
        return val/2;
    }
}

class SDemo2 {
    public static void main(String[] args) {
        System.out.println("val: " + StaticMeth.val);
        System.out.println("StaticMeth.valDiv2(): " +
                StaticMeth.valDiv2());
        StaticMeth.val = 4;
        System.out.println("val: " + StaticMeth.val);
        System.out.println("StaticMeth.valDiv2(): " +
                StaticMeth.valDiv2());
    }
}

// Использование статического блока,
class StaticBlock {
    static double root0f2;
    static double rootof3;
    static {
        System.out.println("Внутри статического блока.");
        root0f2 = Math.sqrt(2.0);
        rootof3 = Math.sqrt(3.0);
    }
    StaticBlock(String msg) {
        System.out.println(msg);
    }
}

class SDemo3 {
    public static void main(String[] args) {
        StaticBlock ob = new StaticBlock("Внутри конструктора.");
        var ob1=new StaticBlock("qwereq");
        System.out.println("Квадратный корень 2: " + StaticBlock.root0f2);
        System.out.println("Квадратный корень 3: " + StaticBlock.rootof3);
    }
}