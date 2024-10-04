class Transport {
    protected String brand;
    protected int year;
    protected double speed;

    public Transport(String brand, int year, double speed) {
        this.brand = brand;
        this.year = year;
        this.speed = speed;
    }

    public void Show() {
        System.out.println("Транспортний засіб: " + brand + ", Рік випуску: " + year + ", Швидкість: " + speed + " км/год");
    }
}

class Car extends Transport {
    private int seats;

    public Car(String brand, int year, double speed, int seats) {
        super(brand, year, speed);
        this.seats = seats;
    }

    @Override
    public void Show() {
        System.out.println("Автомобіль: " + brand + ", Рік випуску: " + year + ", Швидкість: " + speed + " км/год, Кількість місць: " + seats);
    }
}

class Train extends Transport {
    private int carriages;

    public Train(String brand, int year, double speed, int carriages) {
        super(brand, year, speed);
        this.carriages = carriages;
    }

    @Override
    public void Show() {
        System.out.println("Поїзд: " + brand + ", Рік випуску: " + year + ", Швидкість: " + speed + " км/год, Кількість вагонів: " + carriages);
    }

    public int getCarriages() {
        return carriages;
    }
}

class Express extends Train {
    private boolean highSpeed;

    public Express(String brand, int year, double speed, int carriages, boolean highSpeed) {
        super(brand, year, speed, carriages);
        this.highSpeed = highSpeed;
    }

    @Override
    public void Show() {
        System.out.println("Експрес: " + brand + ", Рік випуску: " + year + ", Швидкість: " + speed + " км/год, Кількість вагонів: " + getCarriages() + ", Високошвидкісний: " + (highSpeed ? "Так" : "Ні"));
    }
}

public class Main {
    public static void main(String[] args) {
        Transport[] transports = new Transport[4];

        transports[0] = new Car("Toyota", 2018, 180.0, 5);
        transports[1] = new Train("Hyundai", 2015, 120.0, 10);
        transports[2] = new Express("Siemens", 2020, 300.0, 8, true);
        transports[3] = new Car("Honda", 2021, 200.0, 4);

        for (Transport transport : transports) {
            transport.Show();
        }
    }
}
