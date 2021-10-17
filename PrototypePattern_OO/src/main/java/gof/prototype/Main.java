package gof.prototype;

public class Main {
	  public static void main(String args[]) throws CloneNotSupportedException {
	    Car audi = new Car("A6", 1.9, 130);
	    System.out.println("original car: \t\t\t\t" + audi);

	    Car copy1 = audi.deepClone();
	    System.out.println("deep clone copy: \t\t\t" +  copy1);

	    Car copy2 = audi.shallowClone();
	    System.out.println("shallow clone copy: \t\t" +  copy2);

	    audi.gotoXY(20,30);
	    audi.tune();

	    System.out.println("\nAfter modifications: ");
	    System.out.println("original: \t\t\t\t\t" + audi);
	    System.out.println("deep clone copy: \t\t\t" +  copy1);
	    System.out.println("shallow clone copy: \t\t" +  copy2);
	  }
}
