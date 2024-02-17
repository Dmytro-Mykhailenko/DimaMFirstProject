// Упражнение 4
// Упражнение 7.1.
//
// Построение подкласса Vehicle для представления грузовиков.

interface IVehicle{

    int getFuelcap();

    void setFuelcap(int f);

    int getMpg();

    void setMpg(int m);

}


public class Vehicle implements IVehicle {
    private int passengers;
    private int fuelcap;
    private int mpg;
    // Конструктор для класса Vehicle.
    Vehicle (int p, int f, int m) {
        passengers = p; // количество пассажиров
        fuelcap = f; // запас топлива в галлонах
        mpg = m; // расход топлива в милях на галлон
    }

    // Возвращает дальность поездки,
    int range() {
        return mpg * fuelcap;
    }

    //Рассчитывает объем топлива, необходимого для поездки на заданное расстояние
    double fuelNeeded(int miles) {
        return (double) miles / mpg;
    }

    // Методы доступа к переменным экземпляра,
    int getPassengers() { return passengers; }
    void setPassengers(int p) { passengers = p; }
    public int getFuelcap() { return fuelcap; }
    public void setFuelcap(int f) { fuelcap = f; }
    public int getMpg() { return mpg; }
    public void setMpg(int m) { mpg = m; }
}

//Расширение класса Vehicle для создания специализированного класса Truck
class Truck extends Vehicle {
    private int cargocap; // грузоподъемность в фунтах
    // Конструктор класса Truck.
    Truck(int p, int f, int m, int c) {
//Инициализировать члены Vehicle с использованием конструктора Vehicle
        super(p, f, m);
        cargocap = c;
    }
    // Методы доступа для cargocap.
    int getCargo() { return cargocap; }
    void putCargo(int c) { cargocap = c; }
}

class TruckDemo {
    public static void main(String[] args) {
// Сконструировать несколько объектов, представляющих грузовики.
        Truck semi = new Truck(2, 200, 7, 44000);
        Truck pickup = new Truck(3, 28, 15, 2000);
        double gallons;
        int dist = 252;
        gallons = semi.fuelNeeded(dist);
        System.out.println("Полуприцеп может перевезти " + semi.getCargo() + " фунтов.");
        System.out.println("Для поездки на расстояние " + dist + " миль полуприцепу требуется " + gallons + " галлонов топлива.\n");
        gallons = pickup.fuelNeeded(dist);
        System.out.println("Пикап может перевезти " + pickup.getCargo() + " фунтов.");
        System.out.println("Для поездки на расстояние " + dist + " миль пикапу требуется " + gallons + " галлонов топлива.");
    }
}


class VehConsDemo {
    public static void main(String[] args) {

// Создать объекты транспортных средств.
        Vehicle minivan = new Vehicle(7, 16, 21);
        Vehicle sportscar = new Vehicle(2, 14, 12);
        double gallons;
        int dist = 252;

        gallons = minivan.fuelNeeded(dist);
        System.out.println("Для поездки на расстояние " + dist + " миль минивэну требуется " + gallons + " галлонов топлива.");
        gallons = sportscar.fuelNeeded(dist);
        System.out.println("Для поездки на расстояние " + dist + " миль спортивному автомобилю требуется " + gallons + " галлонов топлива.");
    }
}
