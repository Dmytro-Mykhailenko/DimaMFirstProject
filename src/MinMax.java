import java.util.Random;
import java.util.random.RandomGenerator;

// Поиск минимального и максимального значений в массиве, Перепишите класс MinMax, показанный в начале этой главы, чтобы в нем
//использовался цикл for в стиле “for-each”
class MinMax {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random j= new Random();
        int min, max;
        int c=0;
        for (int i:nums){
            nums[c]= j.nextInt();
            c++;
        }
        min = max = nums[0];
        for (int i:nums) System.out.print(i+" ");
        System.out.println();
        for(int i:nums) {
            if(i < min) min = i;
            if(i > max) max = i;
        }
        System.out.println("Минимальное и максимальное значения: " + min + " " + max);
    }
}