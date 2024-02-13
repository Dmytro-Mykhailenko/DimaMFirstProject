// Упражнение 6.3. Простая версия быстрой сортировки,
class Quicksort {
    // Настраивает вызов фактического метода быстрой сортировки,
    static void qsort(char[] items) {
        qs(items, 0, items.length - 1);
    }

    // Рекурсивная версия быстрой сортировки для символов,
    private static void qs(char[] items, int left, int right) {
        int i, j;
        char x, y;
        i = left;
        j = right;
        x = items[(left + right) / 2];
        do {
            while ((items[i] < x) && (i < right)) i++;
            while ((x < items[j]) && (j > left)) j--;
            if (i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);
    }


    static int sum(int...k){
        int sum=0;
        for (int x:k) sum+=x;
        return sum;
    }
}

class Backwards {
    String str;
    Backwards(String s) {
        str = s;
    }

    //Напишите рекурсивный метод, отображающий содержимое строки в обратном направлении
    void revertStr(int ind){
        if (ind!=0){
            ind--;
            System.out.print(str.charAt(ind));
            revertStr(ind);
        }
        System.out.println();
        System.out.println();
    }
}

class QSDemo {
    public static void main(String[] args) {
        Backwards stri=new Backwards("qwertyuio");
        stri.revertStr(stri.str.length());
        char[] a = {'d','x','a','r','p','j','i'};
        int [] b= {1,2,3,4,5,6,7,8,9,10};
        int i;
        i=Quicksort.sum(1,2,3,4,5,6,7,8,9,10);
        System.out.println(i);
        System.out.print("Исходный массив: ");
        for(i=0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println();
// Отсортировать массив.
        Quicksort.qsort(a);
        System.out.print("Отсортированный массив: ");
        for(i=0; i < a.length; i++)
            System.out.print(a[i]);
    }
}