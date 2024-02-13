/*
В ASCII коды букв нижнего регистра отделены от кодов букв верхнего регистра на 32. Таким образом, для преобразования буквы нижнего регистра
в букву верхнего регистра, из ее кода понадобится вычесть 32. Используйте эту информацию для написания программы, читающей символы с
клавиатуры. Она должна преобразовывать все буквы нижнего регистра в
буквы верхнего регистра, а все буквы верхнего регистра — в буквы нижнего регистра, отображая результат. Остальные символы изменяться не
должны. Программа должна останавливаться, когда пользователь вводит
точку. В конце программа должна выводить количество произошедших
изменений регистра.
 */
public class LetterPlaying {
        public static void main(String[] args)
                throws java.io.IOException {
            char ch;
            int count=0;
            do {
                ch=(char) System.in.read();
                if (ch>='a' & ch<='z') {System.out.print((char) (ch-32)); count++;}
                else if (ch>='A' & ch<='Z') {System.out.print((char) (ch+32)); count++;}
                else System.out.print(ch);

            } while (ch!='.');
            System.out.println("\nПроизошло " + count + " изменений регистра.");

            /*
             Напишите программу, которая читает символы с клавиатуры до тех пор,
пока не будет получена точка. Программа должна подсчитывать количество пробелов и в конце сообщать итог.

            char space;
            int count=0;
            do {
                space = (char) System.in.read();
                if (space == ' ') count++;

            } while (space != '.');
            System.out.println("Space count: " + count);

             */

            /*
            char ch, ignore, answer = 'K';
            do {
                System.out.println("Задумана буква между А и Z.");
                System.out.print("Попробуйте ее угадать: ");
                // Прочитать символ.
                ch = (char) System.in.read();
                // Отбросить все остальные символы из буфера ввода,
                do {
                    ignore = (char) System.in.read();
                } while(ignore != '\n');
                if(ch == answer) System.out.println("** Правильно! **");
                else {
                    System.out.print("...Увы , не угадали. Задуманная буква находится ");
                    if(ch < answer) System.out.println("дальше по алфавиту.");
                    else System.out.println("ближе по алфавиту.");
                    System.out.println("Повторите попытку!\n");
                }
            } while(answer != ch);

            */
        }
    }