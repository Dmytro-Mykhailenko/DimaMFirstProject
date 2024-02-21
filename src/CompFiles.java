/*
Упражнение 10.1.
Сравнение двух файлов.
При запуске программы укажите имена сравниваемых
файлов в командной строке.
java CompFile FIRST.TXT SECOND.TXT
*/
import java.io.*;
class CompFiles {
    public static void main(String[] args) {
        int i=0, j=0, k=0;
// Первым делом удостовериться,что оба имени файлов были указаны ,
        //if(args.length !=2 ) {
            //System.out.println("Использование: CompFiles файл1 файл2");
            //return;
       // }
// Сравнить файлы .
        try (FileInputStream f1 = new FileInputStream("first.txt");
             FileInputStream f2 = new FileInputStream("second.txt"))
        {
// Проверить содержимое каждого файла,
            do {
                i =  f1.read();
                j =  f2.read();
                k++;
                if (i+32==j | i==j+32) continue;
                if(i != j) break;

            } while(i != -1 && j != -1);
            if(i != j)
                System.out.println("Содержимое файлов отличается в позиции " + k);
            else
                System.out.println("Содержимое файлов совпадает.");
        }
        catch(IOException exc) {
            System.out.println("Ошибка ввода-вывода: " + exc);
        }
    }
}

/*
Попробуйте самостоятельно улучшить утилиту CompFiles, включив в нее
новые возможности. Например, добавьте параметр для игнорирования регистра букв.
Или же заставьте CompFiles отображать позицию в файле, в
которой содержимое файлов отличается.
 */