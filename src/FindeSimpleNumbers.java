/*
Упражнение 2.10
Напишите программу, находящую все простые числа от 2 до 100.
 */
public class FindeSimpleNumbers {
    public static void main(String[] args)
    throws java.io.IOException{
        //Задача 2.10
        //Находим простые числа
        int i, j, k, count=0;
        char ch;
        ch = (char) System.in.read();
        //System.out.println("Простые числа: ");
        for (i=2; i<=1000000; i++){
            for (j=2, k=1; j<=i & k!=0;j++){
                k= i % j;
                if (i==j & k==0)
                    //System.out.println(i + ", ");
                    count++;
            }
            // if (i%100==0) System.out.println();
        }
        System.out.println(count);
        ch = (char) System.in.read();

        //*/

        //int i, j;
        boolean isprime;
        count=0;
        ch = (char) System.in.read();
        for(i=2; i < 10000000; i++) {
            isprime = true;
            // Выяснить, делится ли число без остатка,
            for(j=2; j <= i/j; j++)
                // Если делится, тогда оно не является простым,
                if((i%j) == 0) isprime = false;
            if(isprime)
                //System.out.println(i + " - простое число.");
                count++;
        }
        System.out.println(count);
        ch = (char) System.in.read();

    }
}
