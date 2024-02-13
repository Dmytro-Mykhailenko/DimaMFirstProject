// Использование цикла for в стиле "for-each" для двумерного массива,
class ForEach2 {
    public static void main(String[] args) {
        int sum = 0;
        int[][] nums = new int[3][5];
// Поместить некоторые значения в nums.
        for(int i = 0; i < 3; i++)
            for(int j=0; j < 5; j++)
                nums[i][j] = (i+1)*(j+1);
// Применение цикла for в стиле "for-each" для отображения
// и суммирования значений.
        for(int[] x : nums) {
            for(int у : x ) {
                System.out.println("Значение: " + у);
                sum += у;
            }
        }
        System.out.println("Сумма: " + sum);
    }
}

// Поиск в массиве с использованием цикла for в стиле "for-each".
class Search {
    public static void main(String[] args) {
        int[] nums = { 6, 8 , 3 , 1, 5, 6 , 1, 4 };
        int val = 5;
        boolean found = false;
// Применить цикл for в стиле "for-each" для поиска в nums значения val.
        for(int x : nums) {
            if(x == val) {
                found = true;
                break;
            }
        }
        if(found)
            System.out.println("Значение найдено!");
    }
}