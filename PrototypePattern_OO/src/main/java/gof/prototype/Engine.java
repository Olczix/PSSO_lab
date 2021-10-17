package gof.prototype;

import java.awt.color.ICC_ProfileRGB;
import java.io.Serializable;

public class Engine implements IPrototype<Engine>, Cloneable, Serializable {
	private double displacement;
	private int power;

	Engine(double displacement, int power) {
		this.displacement = displacement;
		this.power = power;
	}

	@Override
	public Engine clone() throws CloneNotSupportedException {
		return (Engine) super.clone();
	}

	public void tune() {
		power = power + 25;
	}

	public int getPower() {
		return power;
	}

	public String toString() {
		return " displacement=" + displacement + " power=" + power;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 29 * hash
				+ (int) (Double.doubleToLongBits(this.displacement) ^ (Double.doubleToLongBits(this.displacement) >>> 32));
		hash = 29 * hash + this.power;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Engine other = (Engine) obj;
		if (Double.doubleToLongBits(this.displacement) != Double.doubleToLongBits(other.displacement)) {
			return false;
		}
		if (this.power != other.power) return false;
		return true;
	}

}
