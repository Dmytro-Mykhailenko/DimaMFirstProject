import java.io.*;
import java.lang.*;
class CopyFile {
    public static void main(String[] args) throws IOException {
        args= new String[2];
        args[0]="first.txt";
        args[1]="second.txt";
        int i;
// Первым делом удостовериться, что оба имени файлов были указаны ,
        if(args.length != 2) {
            System.out.println("Использование: CopyFile исходный-файл целевойфайл");
            return;
        }
// Копировать файл,
        BufferedReader fin = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fout = new BufferedWriter(new FileWriter(args[1]));
        try {
// Попытка открытия файлов.
            do {
                i = fin.read();
                if(i != -1){
                    if (i==' ') i='-';
                    fout.write(i);
                }
            } while(i != -1);
        }
        catch(IOException exc) {
            System.out.println("Ошибка ввода-вывода: " + exc);
        }
        finally {
            try {
                fin.close();
                fout.close();
            }
            catch(IOException exc) {
                System.out.println("Ошибка закрытия " + exc);
            }
        }
    }
}

class RWData {
    public static void main(String[] args) {
        int i = 0;
        double d = 1;
        boolean b = true;
        double js=Double.parseDouble("123.23");

// Записать ряд значений.
        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("testdata")))
        {
            System.out.println("Запись " + i);
            dataOut.writeInt(i);
            System.out.println("Запись " + d);
            dataOut.writeDouble(d);
            System.out.println("Запись " + b);
            dataOut.writeBoolean(b);
            System.out.println("Запись " + 12.2 * 7.4);
            //dataOut.writeDouble(12.2 * 7.4);
        }
        catch(IOException exc) {
            System.out.println("Ошибка при записи.");
            return;
        }
        System.out.println();
// Прочитать ранее записанные значения,
        try (var dataIn = new FileInputStream("testdata"))
        {
            int j=0;
            do {
                j=dataIn.read();
                System.out.println(j);
            }while (j != -1);
        }
        catch(IOException exc) {
            System.out.println("Ошибка при чтении.");
        }
    }
}