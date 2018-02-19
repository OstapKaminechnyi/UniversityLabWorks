
public class main {

	public static void main(String[] args) {
	    CartonOfMilk molokiya = new CartonOfMilk();
        CartonOfMilk galychyna = new CartonOfMilk ("Galychyna",20.99, "dark blue", 0.9, 1);
        CartonOfMilk ferma = new CartonOfMilk("Ferma",19.50, "yellow", 1, 23);
	
	System.out.println(molokiya.toString());
    System.out.println(galychyna.toString());
    System.out.println(ferma.toString());
    
    molokiya.resetValues ("Molokiya",23.50 ,"red", 1.5, 5);

    molokiya.printSum();
    galychyna.printSum();
    ferma.printSum();
    
    molokiya.setNumber(5);
    
    CartonOfMilk.printStaticSum();
	}
}


	


