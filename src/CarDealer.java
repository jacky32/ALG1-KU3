import java.util.ArrayList;

public class CarDealer {
  private ArrayList<Car> cars = new ArrayList<Car>();
  public CarDealer() {

  }

  public void addCar(Car car) {
    cars.add(car);
  }

  private boolean testAddCar(Car car) {
    int initialCarCount = cars.size();
    cars.add(car);
    int endCarCount = cars.size();
    return (endCarCount == initialCarCount + 1);
  }
}
