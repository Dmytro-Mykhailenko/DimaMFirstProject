public class OldLessons {
    public static void main(String[] args) {
        System.out.println("Green");
        System.out.println("Blue");
        System.out.println("Yellow");
        System.out.println("    *    ");
        System.out.println("   ***   ");
        System.out.println("  *****  ");
        System.out.println(" ******* ");
        System.out.println("*********");
        System.out.println(" ******* ");
        System.out.println("  *****  ");
        System.out.println("   ***   ");
        System.out.println("    *    ");
        System.out.printf("Hello and welcome!");

        // constants
        final int SCREEN_SIZE = 1024 ;


        // intwgwr
        int weight = 200 ;
        int ageYoung = 10;
        int ageOld = 100;
        int summOfAllages = ageYoung + ageOld ;
        int maxIntNumber = 2147483647 ;
        int moreThanMaxInt = maxIntNumber + 2 ;
        int value = 4 % 3;

        // boolean
        boolean isWeightOk = true;
        boolean isAgeOk = false;
        boolean isOldAgeBiggerThanYoung = ageOld > ageYoung ;

        // rewrite
        weight = 50 ;
        isWeightOk = false ;
        ageOld+=100 ;
        ageYoung-=10 ;


        System.out.println("This is variable content: " + summOfAllages);
        System.out.println("This is variable content: " + weight);

    }

}
