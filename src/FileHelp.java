/*
Упражнение 10.2.
Справочная система, которая использует диск
для хранения справочной информации.
*/
import java.io.*;
/* Класс Help открывает справочный файл, выполняет поиск раздела,
а затем отображает информацию, связанную с этим разделом.
Обратите внимание, что он самостоятельно обрабатывает все
исключения ввода-вывода, избегая необходимости делать это
в вызывающем коде. */

class Helpp {
    String helpfile; // имя справочного файла
    Helpp(String fname) {
        helpfile = fname;
    }
    // Отображение справочной информации по заданной теме,
    boolean helpOn(String what) {
        int ch;
        String topic, info;
    // Открыть справочный файл,
        try (BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile)))
        {
            do {
        // Читать символы, пока не встретится #.
                ch = helpRdr.read();
                // Проверить, соответствует ли тема.
                if(ch == '#') {
                    topic = helpRdr.readLine();
                        if(what.compareTo(topic) == 0) {
                    // Тема найдена,
                            do {
                                info = helpRdr.readLine();
                                if(info != null) System.out.println(info);
                            } while((info != null) && (info.compareTo("") != 0));
                            return true;
                        }
                }
            } while(ch != -1);
        }
        catch(IOException exc) {
            System.out.println("Ошибка доступа к справочному файлу.");
            return false;
        }
        return false; // тема не найдена
    }

// Получение справочной темы
    String getSelection() {
        String topic = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите название темы : ");
        try {
            topic = br.readLine();
        }
        catch(IOException exc) {
            System.out.println("Ошибка при чтении с консоли.");
        }
        return topic;
    }
}

// Демонстрация работы справочной системы , использующей диск,
class FileHelp {
    public static void main(String[] args) {
        Helpp hlpobj = new Helpp("helpfile.txt");
        String topic;
        System.out.println("Демонстрация работы справочной системы . " +
                "Для завершения введите stop.");
        do {
            topic = hlpobj.getSelection();
            if(!hlpobj.helpOn(topic))
                System.out.println("Тема не найдена.\n");
        } while(topic.compareTo("stop") != 0);
    }
}