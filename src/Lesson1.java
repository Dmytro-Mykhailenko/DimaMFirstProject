public class Lesson1 {
    public static void main(String[] args)
            throws java.io.IOException {
        int i;
        for (i=1;i>0;i+=i){
            System.out.println(i);
        }
        /*
        {int var1=1023;
        int var2;
        var2=1023/2;
        System.out.println("adgadgadfg " + var2 + " sdg " + var1);}

        {double earsMass=65, moonMass;
        moonMass=0.17*earsMass;
        System.out.print(earsMass + " kg Земной массы = " + moonMass + " kg на Луне");}
        */

        /*
        {float metres, inches;
            int counter;
            counter = 0;
            for(inches = 1; inches <= 144; inches++) {
                metres = (float) (inches / 39.37); // преобразование в литры
                System.out.println(inches + " inch = " + metres + " м.");
                counter++;
                // После каждой 10-й строки вывести пустую строку,
                if(counter == 12) {
                    System.out.println();
                    counter = 0; // сброс счетчика строк
                }
            }
        }
        */

        /*
        {double dist;
        dist=(7.2/2) * 335;
        System.out.println("Объект на\tхо\tдит\tся\nна расстоянии " + dist + " метров.");}
        */

        ///*


        /*
        // Таблица истинности для базовых логических операций Java
        {boolean p, q;
        System.out.println("P\t\t| Q\t\t| AND & | OR |  | XOR ^ | NOT !");
        p = true; q = true;
        System.out.print(p + "\t| " + q +"\t| ");
        System.out.print((p&q) + "\t| " + (p|q) + "\t| ");
        System.out.println((p^q) + "\t| " + (!p));
        p = true; q = false;
        System.out.print(p + "\t| " + q +"\t| ");
        System.out.print((p&q) + "\t| " + (p|q) + "\t| ");
        System.out.println((p^q) + "\t| " + (!p));
        p = false; q = true;
        System.out.print(p + "\t| " + q +"\t| ");
        System.out.print((p&q) + "\t| " + (p|q) + "\t| ");
        System.out.println((p^q) + "\t| " + (!p));
        p = false; q = false;
        System.out.print(p + "\t| " + q +"\t| ");
        System.out.print((p&q) + "\t| " + (p|q) + "\t| ");
        System.out.println((p^q) + "\t| " + (!p));}*/


        /*
        Упражнение 3.1.
        Простая справочная система по управляющим операторам Java.
        */

                /*
                // Игра
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
                    if(ch == answer) System.out.println("** Правильно **");
                    else {
                        System.out.print("...Увы , не угадали. Задуманная буква находится ");
                        if(ch < answer) System.out.println("дальше по алфавиту.");
                        else System.out.println("ближе по алфавиту.");
                        System.out.println("Повторите попытку!\n");
                    }
                } while(answer != ch);
                */

        /*
        Упражнение 3.2.
        Улучшенная справочная система по управляющим операторам Java,
        в которой используется цикл do-while для обработки выбора
        варианта в меню.
        */

        ///*
        // Справка 2.0

        //*/

        /*
        // Демонстрация break
        int i;
        for(i=1; i<4; i++) {

    one: {
      two:    {
        three:     {
                        System.out.println("\ni равно " + i);
                        if(i==1) break one;
                        if(i==2) break two;
                        if(i==3) break three;
                        // Эта строка код никогда не будет достигнута.
                        System.out.println("не выводится");
                    }
                    System.out.println("После блока three.");
                }
                System.out.println("После блока two.");
            }
            System.out.println("После блока one.");
        }
        System.out.println("После цикла for.");
         */


    }
}