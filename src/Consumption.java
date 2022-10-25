public class Consumption {
  private double city;
  private double highway;
  private double average;

  public Consumption(double city, double highway) {
    this.city = city;
    this.highway = highway;
    this.average = calculateAverage();
  }

  public double getAverage() { return average; }

  private double calculateAverage() {
    return (city + highway) / 2;
  }
}
