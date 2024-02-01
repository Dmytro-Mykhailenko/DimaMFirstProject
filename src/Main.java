//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

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

        // class dogs
        Dogs myFirstDog = new Dogs();
        Dogs mySecondDog = new Dogs();

        myFirstDog.name = "Sharik";
        myFirstDog.breed = "Laika";
        myFirstDog.weight = 0.5;
        myFirstDog.repeatWord("Say Gav!");

        mySecondDog.name = "Zuchka";
        mySecondDog.breed = "Kolly";
        mySecondDog.weight = 0.8;
        mySecondDog.sayGav();
        int result=mySecondDog.sumTwoNumbers(3, 7);
        System.out.println(result);
        System.out.println(mySecondDog.sumTwoNumbers(11, 6));

        // class BloodAnalisys
        BloodAnalysis bloodAnalysis = new BloodAnalysis();
        bloodAnalysis.personalCode="6543234567";
        bloodAnalysis.itemOne=10.4;
        bloodAnalysis.itemTwo=8.7;

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}