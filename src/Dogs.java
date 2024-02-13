public class Dogs {

    String name;
    double weight;
    String breed;
    static int count=0;

    public Dogs(){
        count++;
        System.out.println("We make new dog!");
    }
    //public Dogs() {
       // this.breed = "Dvornyaga";
    //}

    public Dogs(String breed) {
        count++;
        this.breed = breed;
    }

    public void sayGav(){
        System.out.println("Gav Gav!");
    }

    public void repeatWord(String message){
        System.out.println("Repeated"+message);
    }

    public int sumTwoNumbers(int firstNumber, int secondNumber){
        return firstNumber+secondNumber;
    }

}
