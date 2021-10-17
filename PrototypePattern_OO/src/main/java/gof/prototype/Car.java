package gof.prototype;

import java.io.Serializable;

public class Car implements IPrototype<Car>, Cloneable, Serializable {
	  protected Engine engine;
	  protected String name;
	  protected Location location = new Location(0, 0);

	  Car(String name, double displacement, int power) {
	    engine = new Engine(displacement, power);	
	    this.name=name;
	  }

	  @Override
	  public Car clone() throws CloneNotSupportedException {
	  	Car c = (Car) super.clone();
	  	return c;
	  }

	  public void gotoXY(int x, int y) {
	  	this.location.gotoXY(x, y);
	  }	
	    
	  public String toString() {
	    return "name="+ name + engine.toString() + " location=("+location.getX()+";"+location.getY()+")";
	  }

	public void tune() {
	    engine.tune();
	  }
	
	@Override
	public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.engine.hashCode();
        hash = 41 * hash + this.name.hashCode();
        hash = 41 * hash + this.location.hashCode();
        return hash;
	}

	@Override
	public boolean equals(Object obj) {
        if (obj == null) return false;        
        if (getClass() != obj.getClass()) return false;        
        final Car other = (Car) obj;
        if (!this.engine.equals(other.engine)) return false;        
        if (!this.name.equals(other.name)) return false;        
        if (this.location.getX() != other.location.getX()) return false;
        if (this.location.getY() != other.location.getY()) return false;
        return true;
	}

}
