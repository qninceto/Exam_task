package clothes;

import java.util.Random;

import clothes.Dress.DressType;

public class Jacket extends PieceOfClothe  implements Comparable<PieceOfClothe> {

	@Override
	public String toString() {
		return super.toString() + "[hasHood=" + hasHood + "]";
	}

	public enum JacketType implements SubtypeClothing {
		DENIM, LEATHER, WOOL
	}

	private boolean hasHood;

	public Jacket(char size, String description, float price, JacketType subType, boolean hasHood) {
		super(size, description, price, subType, TypeClothing.JACKET);
		this.hasHood = hasHood;
	}

	@Override
	public int compareTo(PieceOfClothe o) {
		return (int) ((this.getPrice()-o.getPrice())*200);
	}

	

}
