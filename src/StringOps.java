// Демонстрация ряда операций со строками,
class StrOps {
    public static void main(String[] args) {
        String strl = "В области программирования веб-приложений язык Java занимает первое место.";
        String str2 = new String(strl);
        String str3 = "Строки Java крайне эффективны .";
        int result, idx;
        char ch;
        System.out.println("Длина strl: " + strl.length());
// Отобразить strl посимвольно,
        for(int i=0; i < strl.length(); i++)
            System.out.print(strl.charAt(i));
        System.out.println();
        if(strl.equals(str2))
            System.out.println("strl равна str2");
        else
            System.out.println("strl не равна str2");
        if(strl.equals(str3))
            System.out.println("strl равна str3");
        else
            System.out.println("strl не равна str3");
        result = strl.compareTo(str3);
        if(result == 0)
            System.out.println("strl и str3 равны ");
        else if(result < 0)
            System.out.println("strl меньше str3");
        else
            System.out.println("strl больше str3");
// Присвоить str2 новую строку.
        str2 = "Один Два Три Один";
        idx = str2.indexOf("Один");
        System.out.println("Индекс первого вхождения подстроки Один: " + idx);
        idx = str2.lastIndexOf("Один");
        System.out.println("Индекс последнего вхождения подстроки Один: " + idx);
    }
}

// Демонстрация использования массивов строк,
class StringArrays {
    public static void main(String[] args) {
        String[] strs = { "Это содержимое", "является", "просто", "тестом." };
        System.out.println("Исходный массив: ");
        for(String s : strs)
            System.out.print(s + " ");
        System.out.println("\n");
// Изменить строки.
        strs[1] = "стало";
        strs[3] = "еще одним тестом!";
        System.out.println("Модифицированный массив: ");
        for(String s : strs)
            System.out.print(s + " ");
    }
}

// Использование substring!),
class SubStr {
    public static void main(String[] args) {
        String orgstr = "Язык Java заставляет веб-сеть двигаться.";
// Создание подстроки из объекта String,
        String substr = orgstr.substring(10, 24);
        System.out.println("orgstr: " + orgstr);
        System.out.println("substr: " + substr);

    }
}

// Использование строк для управления оператором switch,
class StringSwitch {
    public static void main(String[] args) {
        String command = "cancel";
        switch(command) {
            case "connect":
                System.out.println("Подключение");
                break;
            case "cancel":
                System.out.println("Отмена");
                break;
            case "disconnect":
                System.out.println("Отключение");
                break;
            default:
                System.out.println("Ошибочная команда!");
                break;
        }
    }
}
