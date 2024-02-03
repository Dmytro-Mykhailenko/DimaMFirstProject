public class Dogs {

    String name;
    double weight;
    String breed;

    public Dogs() {
        this.breed = "lamba";
    }

    public Dogs(String breed) {
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
