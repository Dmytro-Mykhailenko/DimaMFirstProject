public class App {
    public static void main( String[] args ) {

        // Символы Unicode и 10-тичный код
        char ch=0;

        System.out.println(ch=65386);
        System.out.println(ch=65396);
        System.out.println(ch=65406);

        for(int i=1;i<65536;i++ ) {
            System.out.print((char) i + " "+ i + "| ");
            if (i % 10 == 0) System.out.println();
        }

        double[] area1=new double[10];
        int i;
        double sum=0;

        for (i=0; i<area1.length; i++){
            area1[i]=i+0.5;
            System.out.println(area1[i]);
        }
        for (i=0; i<area1.length; i++){
            sum+=area1[i];
        }
        sum=sum/area1.length;
        System.out.println(sum);
        /*
        double[] area1 = new  double[12];
        double area2[] = new double[12];
        int[] integers = {1, 2, 3, 4, 5};
        Calculator calculator= new Calculator();
        System.out.println( "Calculate!" + calculator.calculateSumOfTwoNumbers(5, 0));
        */
    }
}
