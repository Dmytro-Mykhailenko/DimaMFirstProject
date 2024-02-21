/*
Упражнение 11.1.
Расширение класса Thread.
*/
class MyThread extends Thread {
    // Конструктор нового потока.
    MyThread(String name) {
        super(name); // имя потока
    }

    public static MyThread createAndStart(String name) {
        MyThread myThrd = new MyThread(name);
        myThrd.start();
        return myThrd;
    }

    // Точка входа в поток,
    public void run() {
        System.out.println("Поток " + getName() + " запущен.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В потоке " + getName() + " значение count равно " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println("Поток " + getName() + " прерван.");
        }
        System.out.println("Поток " + getName() + " завершен.");
    }
}

class ExtendThread {
    public static void main(String[] args) {
        System.out.println("Главный поток запущен.");
        MyThread mt = MyThread.createAndStart("Child #1");
        for(int i=0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Главный поток прерван.");
            }
        }
        System.out.println("Главный поток завершен.");
    }
}

// Изменения MyThread. В этой версии MyThread
// объект Thread создается при вызове его конструктора
// и сохраняется в переменной экземпляра по имени thrd.
// Здесь также устанавливается имя потока и предоставляется
// фабричный метод для создания и запуска потока.
class MyThread1 implements Runnable {
    Thread thrd;
    // Сконструировать новый поток, используя эту реализацию
// интерфейса Runnable, и назначить ему имя.
    // Конструктор нового потока.
    MyThread1(String name) {
        thrd = new Thread(this, name);
    }
    // Фабричный метод, который создает и запускает поток,
    public static MyThread1 createAndStart(String name) {
        MyThread1 myThrd = new MyThread1(name);
        myThrd.thrd.start(); // запустить поток
        return myThrd;
    }
    // Точка входа в поток,
    public void run() {
        System.out.println("Поток " + thrd.getName() + " запущен.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В потоке " + thrd.getName() + " значение count равно " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println("Поток " + thrd.getName() + " прерван.");
        }
        System.out.println("Поток " + thrd.getName() + " завершен.");
    }
}

// Создание нескольких потоков.
class MoreThreads {
    public static void main(String[] args) {
        System.out.println("Главный поток запущен.");
        MyThread1 mt1 = MyThread1.createAndStart("Child #1");
        MyThread1 mt2 = MyThread1.createAndStart("Child #2");
        MyThread1 mt3 = MyThread1.createAndStart("Child #3");
        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Главный поток прерван.");
            }
        } while (mt1.thrd.isAlive() ||
                mt2.thrd.isAlive() ||
                mt3.thrd.isAlive());
        System.out.println("Главный поток завершен.");
    }
}

// Создание потока путем реализации интерфейса Runnable.
class MyThread2 implements Runnable {
    String thrdName;
    MyThread2(String name) {
        thrdName = name;
    }
    // Точка входа в поток,
    public void run() {
        System.out.println("Поток " + thrdName + " запущен.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В потоке " + thrdName + " значение count равно " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println("Поток " + thrdName + " прерван.");
        }
        System.out.println("Поток " + thrdName + " завершен.");
    }
}

class UseThreads {
    public static void main(String[] args) {
        System.out.println("Главный поток запущен.");
// Сначала сконструировать объект MyThread.
        MyThread2 mt = new MyThread2("Child #1");
// Затем сконструировать поток из этого объекта.
        Thread newThrd = new Thread(mt);
// Наконец запустить поток на выполнение.
        newThrd.start();
        for(int i=0; i<50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Главный поток прерван.");
            }
        }
        System.out.println("Главный поток завершен.");
    }
}

class ThreadVariations {
    public static void main(String[] args) {
        System.out.println("Главный поток запущен.");
// Создать и запустить поток.
        MyThread1 mt = MyThread1.createAndStart("Child #1");
        for(int i=0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Главный поток прерван.");
            }
        }
        System.out.println("Главный поток завершен.");
    }
}

class JoinThreads {
    public static void main(String[] args) {
        System.out.println("Главный поток запущен.");
        MyThread1 mtl = MyThread1.createAndStart("Child #1");
        MyThread1 mt2 = MyThread1.createAndStart("Child #2");
        MyThread1 mt3 = MyThread1.createAndStart("Child #3");
        try {
            mtl.thrd.join();
            System.out.println("Поток Child #1 присоединен.");
            mt2.thrd.join();
            System.out.println("Поток Child #2 присоединен.");
            mt3.thrd.join();
            System.out.println("Поток Child #3 присоединен.");
        }
        catch(InterruptedException exc) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершен.");
    }
}

// Демонстрация использования приоритетов потоков.
class Priority implements Runnable {
    int count;
    Thread thrd;
    static boolean stop = false;
    static String currentName;
    // Конструктор нового потока.
    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }
    // Точка входа в поток,
    public void run() {
        System.out.println("Поток " + thrd.getName() + " запущен.");
        do {
            count++;
            if(currentName.compareTo(thrd.getName()) != 0) {
                currentName = thrd.getName();
                System.out.println("В потоке " + currentName);
            }
        } while(stop == false && count < 10000000);
        stop = true;
        System.out.println("\nПоток " + thrd.getName() + " завершен.");
    }
}
class PriorityDemo {
    public static void main(String[] args) {
        Priority mt1 = new Priority("Высокий приоритет");
        Priority mt2 = new Priority("Низкий приоритет ");
        Priority mt3 = new Priority("Нормальный приоритет #1");
        Priority mt4 = new Priority("Нормальный приоритет #2");
        Priority mt5 = new Priority("Нормальный приоритет #3");
// Установить приоритеты .
        mt1.thrd.setPriority(Thread.NORM_PRIORITY+2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY-2);
// Оставить потокам mt3, mt4 и mt5 стандартный,
// нормальный уровень приоритета.
// Запустить потоки,
        mt1.thrd.start();
        mt2.thrd.start();
        mt3.thrd.start();
        mt4.thrd.start();
        mt5.thrd.start();
        try {
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
            mt4.thrd.join();
            mt5.thrd.join();
        }
        catch(InterruptedException exc) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("\nПоток с высоким приоритетом досчитал до " + mt1.count);
        System.out.println("Поток с низким приоритетом досчитал до " + mt2.count);
        System.out.println("1-й поток с нормальным приоритетом досчитал до " + mt3.count);
        System.out.println("2-й поток с нормальным приоритетом досчитал до " + mt4.count);
        System.out.println("3-й поток с нормальным приоритетом досчитал до " + mt5.count);
    }
}

// Использование синхронизации для управления доступом.
class SumArray {
    private int sum;
    synchronized int sumArray(int[] nums) {
        sum = 0; // сбросить sum
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            System.out.println("Промежуточная сумма в потоке " + Thread.currentThread().getName() + " равна " + sum);
            try {
                Thread.sleep(10); // разрешить переключение задач
            }
            catch(InterruptedException exc) {
                System.out.println("Поток прерван.");
            }
        }
        return sum;
    }
}

class MyThread3 implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;
    // Конструктор нового потока.
    MyThread3(String name, int[] nums) {
        thrd = new Thread(this, name);
        a=nums;
    }
    // Фабричный метод, который создает и запускает поток,
    public static MyThread3 createAndStart(String name, int[] nums) {
        MyThread3 myThrd = new MyThread3(name, nums);
        myThrd.thrd.start(); // запустить поток
        return myThrd;
    }
    // Точка входа в поток,
    public void run() {
        int sum;
        System.out.println("Поток " + thrd.getName() + " запущен.");
        //synchronized (sa){ //еще один вариант синхронизации, если...
        answer = sa.sumArray(a);
       // } //...синхронизировать метод невозможно
        System.out.println("Сумма в потоке " + thrd.getName() + " равна " + answer);
        System.out.println("Поток " + thrd.getName() + " завершен.");
    }
}
class Sync {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        MyThread3 mt1 = MyThread3.createAndStart("Child #1", a);
        MyThread3 mt2 = MyThread3.createAndStart("Child #2", a);
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch(InterruptedException exc) {
            System.out.println("Главный поток прерван.");
        }
    }
}

// Использование wait() и notify() для имитации работы часов,
class TickTock {
    String state; // хранит состояние часов

    synchronized void tick(boolean running) {
        if(!running) { // остановить часы
            state = "ticked";
            notify(); // уведомить ожидающие потоки
            return;
        }
        try {
            Thread.sleep(500); // разрешить переключение задач
        }
        catch(InterruptedException exc) {
            System.out.println("Поток прерван.");
        }
        System.out.print("Tick ");
        state = "ticked"; // установить текущее состояние в "после "тик""
        notify() ; // позволить методу tock() выполняться. tick() уведомляет tock()
        try {
            while(!state.equals("tocked"))
                wait(); //ожидать завершения работы метода tock(). tick() ожидает tock()
        }
        catch(InterruptedException exc) {
            System.out.println("Поток прерван.");
        }
    }

    synchronized void tock(boolean running) {
        if(!running) { // остановить часы
            state = "tocked";
            notify() ; // уведомить ожидающие потоки
            return;
        }
        try {
            Thread.sleep(500); // разрешить переключение задач
        }
        catch(InterruptedException exc) {
            System.out.println("Поток прерван.");
        }
        System.out.println("Tock");
        state = "tocked"; // установить текущее состояние  в "после "так""
        notify() ; // позволить методу tick() выполняться. tock() уведомляет tick()
        try {
            while(!state.equals("ticked"))
                wait(); // ожидать завершения работы метода tick(). tock() ожидает tick()
        }
        catch(InterruptedException exc) {
            System.out.println("Поток прерван.");
        }
    }
}

class MyThread4 implements Runnable {
    Thread thrd;
    TickTock ttOb;
    // Конструктор нового потока.
    MyThread4(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
    }
    // Фабричный метод, который создает и запускает поток,
    public static MyThread4 createAndStart(String name, TickTock tt) {
        MyThread4 myThrd = new MyThread4(name, tt);
        myThrd.thrd.start(); // запустить поток
        return myThrd;
    }
    // Точка входа в поток,
    public void run() {
        if(thrd.getName().compareTo("Tick") == 0) {
            for(int i=0; i<5; i++) ttOb.tick(true);
            ttOb.tick(false);
        }
        else {
            for(int i=0; i<5; i++) ttOb.tock(true);
            ttOb.tock(false);
        }
    }
}
class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread4 mt1 = MyThread4.createAndStart("Tick", tt);
        MyThread4 mt2 = MyThread4.createAndStart("Tock", tt);
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch(InterruptedException exc) {
            System.out.println("Главный поток прерван.");
        }
    }
}

// Приостановка, возобновление и останов потока.
class MyThread5 implements Runnable {
    Thread thrd;
    boolean suspended;
    boolean stopped;
    MyThread5(String name) {
        thrd = new Thread(this, name);
        suspended = false; //Когда значением является true, поток приостанавливается
        stopped = false; //Когда значением является true, поток останавливается
    }
    // Фабричный метод, который создает и запускает поток,
    public static MyThread5 createAndStart(String name) {
        MyThread5 myThrd = new MyThread5(name);
        myThrd.thrd.start(); // запустить поток
        return myThrd;
    }
    // Точка входа в поток,
    public void run() {
        System.out.println("Поток " + thrd.getName() + " запущен.");
        try {
            for(int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if((i%10)==0) {
                    System.out.println();
                    Thread.sleep(250);
                }
// Использовать блок synchronized для проверки
// значений suspended и stopped,
                synchronized(this) { //В этом блоке synchronized проверяются значения
                                    // переменных suspended и stopped
                    while(suspended) {
                        wait();
                    }
                    if(stopped) break;
                }
            }
        }
        catch (InterruptedException exc) {
            System.out.println("Поток " + thrd.getName() + " прерван.");
        }
        System.out.println("Поток " + thrd.getName() + " завершен.");
    }
    // Останавливает поток,
    synchronized void mystop() {
        stopped = true;
        // Следующие операторы гарантируют, что приостановленный
// поток может быть остановлен,
        suspended = false;
        notify();
    }
    // Приостанавливает поток,
    synchronized void mysuspend() {
        suspended = true;
    }
    // Возобновляет выполнение потока,
    synchronized void myresume() {
        suspended = false;
        notify();
    }
}
class Suspend {
    public static void main(String[] args) {
        MyThread5 mtl = MyThread5.createAndStart("My Thread");
        try {
            Thread.sleep(1000);
            mtl.mysuspend() ;
            System.out.println("Приостановка потока.");
            Thread.sleep(1000);
            mtl.myresume();
            System.out.println("Возобновление выполнения потока.");
            Thread.sleep(1000);
            mtl.mysuspend();
            System.out.println("Приостановка потока.");
            Thread.sleep(1000);
            mtl.myresume();
            System.out.println("Возобновление выполнения потока.");
            Thread.sleep(1000);
            mtl.mysuspend();
            System.out.println("Останов потока.");
            mtl.mystop();
// позволить потоку obi начать выполнение
        }
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван.");
        }
// Ожидать завершения работы потока,
        try {
            mtl.thrd.join();
        }
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершен.");
    }
}

/*
Упражнение 11.2.
Управление главным потоком.
*/
class UseMain {
    public static void main(String[] args) {
        Thread thrd;
// Получить главный поток,
        thrd = Thread.currentThread();
// Отобразить имя главного потока.
        System.out.println("Имя главного потока: " + thrd.getName());
// Отобразить приоритет главного потока.
        System.out.println("Приоритет главного потока: " + thrd.getPriority());
        System.out.println();
// Установить имя и приоритет.
        System.out.println("Установка имени и приоритета.\n");
        thrd.setName("Thread #1");
        thrd.setPriority(Thread.NORM_PRIORITY+3);
        System.out.println("Новое имя главного потока: " + thrd.getName());
        System.out.println("Новый приоритет главного потока: " + thrd.getPriority());

    }
}