// Использование выведения типов локальных переменных
// с классами, определенными пользователем.
class MyClass {
    private int i;
    MyClass(int k) { i = k; }
    int geti() { return i; }
    void seti(int k) { if(k >= 0) i = k; }
}
class VarDemo2 {
    public static void main(String[] args) {
        var mc = new MyClass(10); // Обратите внимание на применение var.
        System.out.println("Значение i в me равно " + mc.geti() );
        mc.seti(19);
        System.out.println("Значение i в me теперь равно " + mc.geti() );
    }
}

// Использование выведения типов локальных переменных в цикле for.
class VarDemo3 {
    public static void main(String[] args) {
// Применить выведение типов к переменной управления циклом.
        System.out.print("Значения х: ");
        for (var х = 2.5; х < 100.0; х = х * 2)
            System.out.print(х + " ");
        System.out.println();
// Применить выведение типов к переменной итерации.
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.print("Значения в массиве nums: ");
        for (var v : nums)
            System.out.print(v + " ");
        System.out.println();
    }
}