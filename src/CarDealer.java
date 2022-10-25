import java.util.ArrayList;

public class CarDealer {
  private ArrayList<Car> cars = new ArrayList<Car>();
  public CarDealer() {

  }

  public void addCar(Car car) {
    cars.add(car);
  }

  public int getCarCount() { return cars.size(); }

  public Car getCarByModel(String model) {
    for (Car car: cars) {
      if(car.getModel().equals(model)) { return car; }
    }
    return null;
  }

  public Car[] getCarsByManufacturer(String manufacturer) {
    ArrayList<Car> carsByManufacturer = new ArrayList<Car>();
    for (Car car: cars) {
      if(car.getManufacturer().equals(manufacturer)) { carsByManufacturer.add(car); }
    }
    return carsByManufacturer.toArray(new Car[0]);
  }

  private boolean testGetCarsByManufacturer() {
    Consumption testConsumption = new Consumption(4, 6, 5);
    String manufacturer = "tested manufacturer";
    Car testCar1 = new Car("A7", manufacturer, 32, testConsumption, 400000, Fuel.Diesel);
    Car testCar2 = new Car("A5", manufacturer, 24, testConsumption, 200000, Fuel.Hybrid);
    Car testCar3 = new Car("A4", "BMW", 32, testConsumption, 250000, Fuel.Petrol);
    cars.add(testCar1);
    cars.add(testCar2);
    cars.add(testCar3);
    Car[] givenCars = getCarsByManufacturer(manufacturer);
    int sameCars = 0;
    for (Car givenCar : givenCars) {
      if (givenCar == testCar1 || givenCar == testCar2) sameCars++;
    }
    return (sameCars == 2 && givenCars.length == 2);
  }

  public String runTests() {
    int passedTests = 0;
    int runTests = 0;
    Consumption testConsumption = new Consumption(4, 6, 5);
    Car testCar = new Car("A7", "Audi", 32, testConsumption, 200000, Fuel.Diesel);

    if (testGetCarByModel()) passedTests++;
    runTests++;
    if (testAddCar(testCar)) passedTests++;
    runTests++;
    if (testGetCarsByManufacturer()) passedTests++;
    runTests++;

    if (passedTests == runTests) {
      return "All tests passed";
    } else {
      return runTests - passedTests + "tests failed";
    }
  }

  private boolean testGetCarByModel() {
    String firstModel = "test model";
    String secondModel = "nonexistent model";
    Car givenCar = new Car(firstModel, "man", 20, null, 0, Fuel.Diesel);
    cars.add(givenCar);
    Car firstReturnedCar = getCarByModel(firstModel);
    Car secondReturnedCar = getCarByModel(secondModel);
    return (firstReturnedCar == givenCar &&
            secondReturnedCar == null);
  }

  private boolean testAddCar(Car car) {
    int initialCarCount = getCarCount();
    cars.add(car);
    int endCarCount = getCarCount();
    return (endCarCount == initialCarCount + 1);
  }
}
