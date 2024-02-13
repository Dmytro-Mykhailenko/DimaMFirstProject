/*
Упражнение 5.1.
Сортировка массива.
*/
public class SortString {
    public static void main(String[] args) {
        String[] nums = {"Пузырьковая сортировка. ", "Шейкерная сортировка. ", "Чётно-нечётная сортировка. ", "Сортировка расчёской. "};

// количество сортируемых элементов
// Отобразить исходный массив.
        System.out.print("Исходный массив:");
        for (String i : nums) System.out.print(" " + i + i.length());
        System.out.println();
// Пузырьковая сортировка.
        for (int a=0; a<nums.length-1; a++)
            for (int b = 1; b <nums.length-a; b++) {
                if(nums[b-1].length() > nums[b].length()) { // Если порядок следования не соблюден,
// тогда поменять элементы местами.
                    String t = nums[b-1];
                    nums[b-1] = nums[b];
                    nums[b] = t;
                }
            }
// Отобразить отсортированный массив.
        System.out.print("Отсортированный массив:");
        for(String i : nums)
            System.out.print(" " + i + i.length());
        System.out.println();

    }
}