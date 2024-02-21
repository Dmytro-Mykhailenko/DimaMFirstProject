import java.io.*;
class RandomAccessDemo {
    public static void main(String[] args) {
        double[] data = {19.4, 10.1, 123.54, 33.0, 87.9, 74.25};
        double d;
// Открыть и использовать файл с произвольным доступом,
        try (RandomAccessFile raf = new RandomAccessFile("random.dat", "rw"))
        {
            // Записать значения в файл.
            for(int i=0; i < data.length; i++) {
                raf.writeDouble(data[i]);
            }
// Прочитать определенные значения.
            raf.seek(0); // перейти на первое значение double
            d = raf.readDouble() ;
            System.out.println("Первое значение: " + d);
            raf.seek(8); // перейти на второе значение double
            d = raf.readDouble() ;
            System.out.println("Второе значение: " + d);
            raf.seek(8 * 3); // перейти на четвертое значение double
            d = raf.readDouble();
            System.out.println("Четвертое значение: " + d);
            System.out.println();
            // Прочитать каждое второе значение.
            System.out.println("Каждое второе значение: ");
            for(int i=0; i < data.length; i+=2) {
                raf.seek(8 * i); // перейти на i-тое значение double
                d = raf.readDouble();
                System.out.print(d + " ");
            }
        }
        catch(IOException exc) {
            System.out.println("Ошибка ввода-вывода: " + exc);
        }
    }
}