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

  public String runTests() {
    int passedTests = 0;
    int runTests = 0;
    Consumption testConsumption = new Consumption(4, 6, 5);
    Car testCar = new Car("A7", "Audi", 32, testConsumption, 200000, Fuel.Diesel);

    if (testGetCarByModel()) passedTests++;
    runTests++;
    if (testAddCar(testCar)) passedTests++;
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
