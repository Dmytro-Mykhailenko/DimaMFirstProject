// Буквы верхнего регистра,
class UpCase {
    public static void main(String[] args) {
        char ch;
        for(int i=0; i < 10; i++) {
            ch = (char) ('a' + i);
            System.out.print(ch);
// Этот оператор отключает бит 6.
            ch = (char) ((int) ch & 65503); // теперь ch содержит букву
// верхнего регистра
            System.out.print (ch + " ");
        }
    }
}

// Буквы нижнего регистра,
class LowCase {
    public static void main(String[] args) {
        char ch;
        for(int i=0; i < 10; i++) {
            ch = (char) ('A' + i);
            System.out.print(ch);
// Этот оператор включает бит 6.
            ch = (char) ((int) ch|32); //теперь ch содержит букву нижнего регистра
            System.out.print(ch + " ");
        }
    }
}

// Использование операции исключающего ИЛИ для кодирования
// и декодирования сообщения.
class Encode {
    public static void main(String[] args) {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        int key = 88;
        System.out.print("Исходное сообщение: ");
        System.out.println(msg);
// Закодировать сообщение,
        for(int i=0; i < msg.length(); i++)
            encmsg = encmsg + (char) (msg.charAt(i) ^ key);
        System.out.print("Закодированное сообщение: ");
        System.out.println(encmsg);
// Декодировать сообщение.
        for(int i=0; i < msg.length(); i++)
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key);
        System.out.print("Декодированное сообщение: ");
        System.out.println(decmsg);
    }
}

class EncodeString {
    public static void main(String[] args) {
        String msg = "This is a test";
        String sKey="orqoiufg";
        String encmsg = "";
        String decmsg = "";
        char buf;

        System.out.println(msg);

    // Кодировка строки
        for (int i=0; i<msg.length();i++){
            buf=msg.charAt(i);
            for (int j=0; j<sKey.length(); j++)
                buf=(char) (buf^sKey.charAt(j));
            encmsg = encmsg + buf;
        }

        System.out.println(encmsg);
        System.out.println(encmsg.length());

    // Декодировка строки
        for (int i=0; i<encmsg.length();i++){
            buf=encmsg.charAt(i);
            for (int j=0; j<sKey.length(); j++)
                buf=(char) (buf^sKey.charAt(j));
            decmsg = decmsg + buf;
        }
        System.out.println(decmsg);


        /*for (int j=0;j<sKey.length();j++){
                while ()buf=(char) (buf^sKey.charAt(j));
                b=sKey.charAt(j);
                c=(char) (a^b);
                System.out.println(buf);
                //buf =  (msg.charAt(i) ^ sKey.charAt(j));
            }

             */
// Декодирование строки

/*
        for (int i=0; i<encmsg.length();i++){
            for (int j=sKey.length()-1;j>=0;j--){
                decmsg = decmsg + (encmsg.charAt(i) ^ sKey.charAt(j));
            }
        }
        System.out.println(decmsg);*/


        /*/Преобразуем строки в массивы символов char
        char[] strToChr=new char[sKey.length()];
        char[] msgToChr=new char[msg.length()];

        for (int i=0; i<sKey.length();i++ ){
            strToChr[i]=sKey.charAt(i);
        }

        for (int i=0; i<msg.length();i++ ){
            msgToChr[i]=msg.charAt(i);
        }
        // Кодировка символов
        char buf;
        for (int i=1; i<=msg.length();i++){
            for (int j=1;j<=sKey.length();j++){
                msg.charAt(i) ^= sKey.charAt(j);
            }
        }

        for (char j:msgToChr) System.out.print(j);
        System.out.print("Исходное сообщение: ");
        System.out.println(msg);
// Закодировать сообщение,
        for(int i=0; i < msg.length(); i++)
            encmsg = encmsg + (char) (msg.charAt(i) ^ key);
        System.out.print("Закодированное сообщение: ");
        System.out.println(encmsg);
// Декодировать сообщение.
        for(int i=0; i < msg.length(); i++)
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key);
        System.out.print("Декодированное сообщение: ");
        System.out.println(decmsg);

         */
    }
}

// Демонстрация работы операции побитового НЕ.
class NotDemo {
    public static void main(String[] args) {
        byte b = -34;
        for(int t=128; t > 0; t = t/2) {
            if((b & t) != 0) System.out.print("1 ");
            else System.out.print("0 ");
        }
        System.out.println();
// Изменить состояние всех битов на противоположное,
        b = (byte) ~b;
        for(int t=128; t > 0; t = t/2) {
            if((b & t) != 0) System.out.print("1 ");
            else System.out.print("0 ");
        }
    }
}

// Демонстрация работы операций << и ».
class ShiftDemo {
    public static void main(String[] args) {
        int val = 1;
        for(int i = 0; i < 8; i++) {
            for(int t=128; t > 0; t = t/2) {
                if((val & t) != 0) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
            val = val << 1; // сдвиг влево
        }
        System.out.println();
        val = 128;
        for(int i = 0; i < 8; i++) {
            for(int t=128; t > 0; t = t/2) {
                if((val & t) != 0) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
            val = val >> 1; // сдвиг вправо
        }
    }
}