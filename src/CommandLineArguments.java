// Отображение всех аргументов командной строки.
class CLDemo {
    public static void main(String[] args) {
        System.out.println("Количество аргументов, переданных программе: "
                + args.length);
        System.out.println("Список аргументов: ");
        for(int i=0; i<args.length; i++)
            System.out.println("arg[" + i + "]: " + args[i]);
    }
}

// Простая автоматизированная телефонная книга,
class Phone {
    public static void main(String[] args) {
        String[][] numbers = {
                { "Tom", "555-3322" },
                { "Mary", "555-8976" },
                { "Jon", "555-1037" },
                { "Rachel", "555-1400" }
        } ;
        int i;
        if(args.length != 1)
            System.out.println("Использование: java Phone <имя>");
        else {
            for(i=0; i<numbers.length; i++) {
                if(numbers[i][0].equals(args[0])) {
                    System.out.println(numbers[i][0] + ": " + numbers[i][1]);

                    break;
                }
            }
            if(i == numbers.length)
                System.out.println("Имя не найдено.");
        }
    }
}

