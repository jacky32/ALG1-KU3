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

  public Car[] getCarsUnderAverageConsumption(double consumption) {
    ArrayList<Car> carsUnderAvgCons = new ArrayList<Car>();
    for (Car car: cars ) {
      if(car.getAverageConsumption() < consumption) { carsUnderAvgCons.add(car); }
    }
    return carsUnderAvgCons.toArray(new Car[0]);
  }

  private boolean testGetCarsUnderAverageConsumption() {
    Consumption testConsumption1 = new Consumption(5, 6);
    Consumption testConsumption2 = new Consumption(1, 3);
    Consumption testConsumption3 = new Consumption(3, 6);
    Car testCar1 = new Car("A7", "Audi", 32, testConsumption1, 400000, Fuel.Diesel);
    Car testCar2 = new Car("A5", "Audi", 24, testConsumption2, 200000, Fuel.Hybrid);
    Car testCar3 = new Car("A4", "BMW", 32, testConsumption3, 250000, Fuel.Petrol);
    cars.add(testCar1);
    cars.add(testCar2);
    cars.add(testCar3);
    Car[] givenCars = getCarsUnderAverageConsumption(5);
    int sameCars = 0;
    for (Car givenCar : givenCars) {
      if (givenCar == testCar2 || givenCar == testCar3) sameCars++;
    }
    return (sameCars == 2 && givenCars.length == 2);
  }

  private boolean testGetCarsByManufacturer() {
    Consumption testConsumption = new Consumption(4, 6);
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
    Consumption testConsumption = new Consumption(4, 6);
    Car testCar = new Car("A7", "Audi", 32, testConsumption, 200000, Fuel.Diesel);

    cars.clear();
    if (testGetCarByModel()) passedTests++;
    runTests++;

    cars.clear();
    if (testAddCar(testCar)) passedTests++;
    runTests++;

    cars.clear();
    if (testGetCarsByManufacturer()) passedTests++;
    runTests++;

    cars.clear();
    if (testGetCarsUnderAverageConsumption()) passedTests++;
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
