import java.util.Random;
public class Main {
    public static void main(String[] args) {

        // class dogs
        Dogs myFirstDog = new Dogs();
        Dogs mySecondDog = new Dogs();
        Dogs myThirdDog =  new Dogs();
        Dogs myFoursDog = new Dogs("Sfoi");

        System.out.println(myThirdDog.breed);
        System.out.println(myFoursDog.breed);

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

        System.out.println(Dogs.count);
        // class BloodAnalisys
        BloodAnalysis bloodAnalysis = new BloodAnalysis();

        bloodAnalysis.personalCode="6543234567";
        bloodAnalysis.itemOne=10.4;
        bloodAnalysis.itemTwo=8.7;


        //int c= new Random().nextInt();
        //for (;c!=5;){
            //c= new Random().nextInt();
            //System.out.println(c);
        //}
        //for (short c=1; c >= -32768;){
           // System.out.println(c);
          //  c++;
        //}

        //for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
           // System.out.println("i = " + i);
        //}
    }
}