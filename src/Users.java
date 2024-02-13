public class Users {
    String name;
    short age;
    int height;
    char type;
    static int count=0;

    public Users(String name, int age, int height){
        if (age<=110 & height>110){
            this.age=(short) age;
            this.height=height;
        }
        else if (height<=110 & age>110){
            this.height= age;
            this.age=(short) height;
        }

        this.name=name;
        this.type='a';
        count++;
    }
    public Users(int age, String name, int height){
        if (age<=110 & height>110){
            this.age=(short) age;
            this.height=height;
        }
        else if (height<=110 & age>110){
            this.height= age;
            this.age=(short) height;
        }

        this.name=name;
        this.type='b';
        count++;
    }
    public Users(int age, int height, String name){
        if (age<=110 & height>110){
            this.age=(short) age;
            this.height=height;
        }
        else if (height<=110 & age>110){
            this.height= age;
            this.age=(short) height;
        }

        this.name=name;
        this.type='c';
        count++;
    }
    public static void main(String[] args) {

        Users user1=new Users("Masha", 54, 167);
        Users user2=new Users("Misha", 174, 34);
        Users user3=new Users(180, 80, "Aleks");
        Users user4=new Users(18, 175, "Gena");
        Users user5=new Users(47, "Sasha", 50);
        Users user6=new Users(155, "Gosha", 35);
        System.out.println(count);
        System.out.println("ByBy!");
    }
}
