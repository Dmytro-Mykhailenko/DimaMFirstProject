package qpack;

// Исключение для ошибок, связанных с переполненной очередью,
class QueueFullException extends Exception {
    int size;
    QueueFullException(int s) { size = s; }
    public String toString() {
        return "\nОчередь переполнена. Максимальный размер составляет " + size + " элементов.";
    }
}

// Исключение для ошибок, связанных с пустой очередью,
class QueueEmptyException extends Exception {
    public String toString() {
        return "\nОчередь пуста.";
    }
}

// Класс для представления очереди символов фиксированного размера,
class FixedQueue implements ICharQ {
    private char[] q; // массив, в котором хранится очередь
    private int putloc, getloc; // индексы для позиций помещения и извлечения

// Конструктор пустой очереди заданного размера,
    public FixedQueue(int size) {
        q = new char[size]; // выделение памяти под очередь
        putloc = getloc = 0;
    }

    // Поместить символ в очередь.
    public void put(char ch) throws QueueFullException {
        if(putloc==q.length) throw new QueueFullException(q.length);

        q[putloc++]=ch;
    }

    // Извлечь символ из очереди,
    public char get() throws QueueEmptyException {
        if(getloc == putloc) throw new QueueEmptyException();

        return q[getloc++];
    }
}

// Кольцевая очередь.
class CircularQueue implements ICharQ {
    private char[] q; // массив, в котором хранится очередь
    private int putloc, getloc; // индексы для позиций помещения и извлечения

// Конструктор пустой очереди заданного размера,
    public CircularQueue(int size) {
        q = new char[size+1];
        putloc = getloc = 0;
// выделение памяти под очередь
    }

    // Поместить символ в очередь,
    public void put(char ch) throws QueueFullException {
/*Очередь переполнена,если либо putloc на единицу меньше getloc,
либо putloc указывает на конец массива,a getloc -на его начало*/
        if(putloc+1==getloc |((putloc==q.length-1) & (getloc==0))) throw new QueueFullException(q.length);

        q[putloc++] = ch;
        if(putloc==q.length) putloc = 0; // закольцевать
    }

    // Извлечь символ из очереди,
    public char get() throws QueueEmptyException {
        if(getloc == putloc) throw new QueueEmptyException();

        char ch = q[getloc++];
        if(getloc==q.length) getloc = 0; // закольцевать
        return ch;
    }
}

class Stack implements ICharQ{
    private char[] q;
    private int loc; // индексы для позиций помещения и извлечения
    public Stack(int size) {
        q = new char[size]; // выделение памяти под очередь
        loc = 0;
    }
    // Поместить символ в очередь,
    public int getLength(){
        return q.length;
    }
    public void put(char ch) throws QueueFullException {
        if(loc==q.length) throw new QueueFullException(q.length);

        q[loc++]=ch;
    }
    // Извлечь символ из очереди,
    public char get() throws QueueEmptyException {
        if(loc == 0) throw new QueueEmptyException();

        return q[--loc];
    }
}

// Динамическая очередь.
class DynQueue implements ICharQ {
    private char[] q;  // массив, в котором хранится очередь
    private int putloc, getloc; // индексы для позиций помещения и извлечения

// Конструктор пустой очереди заданного размера,
    public DynQueue(int size) {
        q = new char[size]; // выделение памяти под очередь
        putloc = getloc = 0;
    }

    // Поместить символ в очередь,
    public void put(char ch) {
        if(putloc==q.length) {
// Увеличить размер очереди.
            char[] t = new char[q.length * 2];
// Скопировать элементы в новую очередь,
            for(int i=0; i < q.length; i++)
                t[i] = q[i];
            q = t;
        }
        q[putloc++]=ch;
    }

    // Извлечь символ из очереди,
    public char get() throws QueueEmptyException {
        if(getloc == putloc) throw new QueueEmptyException();
        return q[getloc++];
    }
}

// Демонстрация использования интерфейса ICharQ.
class IQDemo {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        FixedQueue q1 = new FixedQueue(10);
        DynQueue q2 = new DynQueue(5);
        CircularQueue q3 = new CircularQueue(10);
        Stack q4 = new Stack(10);
        ICharQ iQ;
        char ch;
        int i;
        iQ = q1;

// Поместить ряд символов в очередь фиксированного размера,
        try {
            for(i=0; i < 10; i++)
                iQ.put((char) ('A' + i));
        }
        catch (QueueFullException ext) {
            System.out.println(ext);
        }

// Отобразить содержимое очереди.
        System.out.print("Содержимое очереди фиксированного размера: ");
        try {
            for(i=0; i < 10; i++) {
                ch = iQ.get();
                System.out.print(ch);
            }
        }
        catch (QueueEmptyException ext) {
            System.out.println(ext);
        }
        System.out.println();

        // Dynamic Queue
        iQ = q2;

// Поместить ряд символов в динамическую очередь.
        try {
            for(i=0; i < 10; i++) iQ.put((char) ('Z' - i));
        }
        catch (QueueFullException exc) {
            System.out.println(exc);
        }

        // Отобразить содержимое очереди.
        System.out.print("Содержимое динамической очереди: ");

        try {
            for(i=0; i < 10; i++) {
                ch = iQ.get();
                System.out.print(ch);
            }
        }
        catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();

        // Circular queue
        iQ = q3;

// Поместить ряд символов в кольцевую очередь.
        try {
            for(i=0; i < 10; i++)
                iQ.put((char) ('A' + i));
        }
        catch (QueueFullException exc) {
            System.out.println(exc);
        }

// Отобразить содержимое очереди.
        System.out.print("Содержимое кольцевой очереди: ");

        try {
            for(i=0; i < 10; i++) {
                ch = iQ.get();
                System.out.print(ch);
            }
        }
        catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();

        // Поместить дополнительные символы в кольцевую очередь,
        try {
            for(i=10; i < 20; i++)
                iQ.put((char) ('A' + i));
        }
        catch (QueueFullException exc) {
            System.out.println(exc);
        }

// Отобразить содержимое очереди.
        System.out.print("Содержимое кольцевой очереди: ");

        try {
            for(i=0; i < 10; i++) {
                ch = iQ.get();
                System.out.print(ch);
            }
        }
        catch (QueueEmptyException exc) {
            System.out.println(exc);
        }

        System.out.println("\nСохранение и использование элементов в кольцевой очереди.");
// Сохранение и использование элементов в кольцевой очереди.
        try {
            for(i=0; i < 20; i++) {
                iQ.put((char) ('A' + i));
                ch = iQ.get();
                System.out.print(ch);
            }
        }
        catch (QueueFullException | QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();

        // Stack
        iQ=q4;

        // Поместить дополнительные символы в стек
        try {
            for(i=0; i < q4.getLength(); i++)
                iQ.put((char) ('A' + i));
        }
        catch (QueueFullException exc) {
            System.out.println(exc);
        }

// Отобразить содержимое очереди.
        System.out.print("Содержимое стека: ");

        try {
            for(i=0; i < q4.getLength(); i++) {
                ch = iQ.get();
                System.out.print(ch);
            }
        }
        catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();
    }
}