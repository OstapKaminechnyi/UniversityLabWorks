
public class CartonOfMilk {

	    private String name = "Untitled";
	    private double price;
	    private String color;
	    private double capacity;
	    private int number;
	    public static int generalNumber = 0;

    public CartonOfMilk () {
	
}

    public CartonOfMilk (String name, double price, String color, double capacity) {
        setName(name);
        setPrice (price);
        setColor (color);
        setCapacity (capacity);

}
    public CartonOfMilk (String name, double price, String color, double capacity, int number ) {
        setName(name);
        setPrice (price);
        setColor (color);
        setCapacity (capacity);
        setNumber (number);
}
    @Override
    public String toString() {
        return "Carton is called  " + name + ", costs " + price + ", colored "
    + color + ",has capacity  " + capacity + ", accounts for " + number;
}
    static void printStaticSum() {
        System.out.println("Overall number is " + generalNumber + " cartons");
    }
    public void printSum() {
        System.out.println("Carton is called " + name + ", cartons of milk of this brand " + number + " total number of cartons of milk  " + generalNumber);
    }
    public void resetValues(String name, double price, String color , double capacity, int number) {
        setName(name);
        setPrice(price);
        setColor(color);
        setCapacity(capacity);
        setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }
    public void setColor (String color) {
    	this.color = color;
    }
    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

  public int getNumber () {
	  return number;
  }

    public void setNumber (int number) {
        generalNumber -= this.number;
        this.number = number;
        generalNumber += this.number;
    }
    }
    
    

