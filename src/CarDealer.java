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
      if(car.getModel()==model) { return car; }
    }
  }

  private boolean testAddCar(Car car) {
    int initialCarCount = getCarCount();
    cars.add(car);
    int endCarCount = getCarCount();
    return (endCarCount == initialCarCount + 1);
  }
}
