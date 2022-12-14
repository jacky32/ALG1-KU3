public class Car {
  private String model;
  private String manufacturer;
  private int kilometers;
  private Consumption consumption;
  private int price;
  private Fuel fuel;

  public Car(String model, String manufacturer, int kilometers, Consumption consumption, int price, Fuel fuel) {
    this.model = model;
    this.manufacturer = manufacturer;
    this.kilometers = kilometers;
    this.consumption = consumption;
    this.price = price;
    this.fuel = fuel;
  }

  public String getModel() { return model; }

  public String getManufacturer() { return manufacturer; }
  public Fuel getFuel() { return fuel; }

  public double getAverageConsumption() { return consumption.getAverage(); }
}
