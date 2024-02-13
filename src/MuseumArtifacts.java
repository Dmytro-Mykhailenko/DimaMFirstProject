public class MuseumArtifacts {
    int id;
    String culture;
    int century;
    static int count=0;

    public MuseumArtifacts(int id){
        count++;
        this.id=id;
    }
    public MuseumArtifacts(int id, String culture ){
        count++;
        this.id=id;
        this.culture=culture;
    }
    public MuseumArtifacts(int id, String culture, int century){
        count++;
        this.id=id;
        this.culture=culture;
        this.century=century;
    }
    public static void main(String[] args) {
        var artifact3=new MuseumArtifacts(212121, "Actek", 21);
        var artifact1=new MuseumArtifacts(212121);
        var artifact2=new MuseumArtifacts(212121, "Actek");

        System.out.println(count);
    }
}
