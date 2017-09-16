package clothes;

import java.util.Random;

import clothes.Pants.PantsType;

public class Dress extends PieceOfClothe  implements Comparable<PieceOfClothe>  {
	
	@Override
	public String toString() {
		return super.toString() + " [hasZipper=" + hasZipper + "]";
	}

	public enum DressType implements SubtypeClothing {
		COCKTAIL, BEACH, OFICIAL, WOOL
	}
	
	private boolean hasZipper;

	public Dress(char size, String description, float price, DressType subType, boolean hasZipper) {
		super(size, description, price, subType, TypeClothing.DRESS);
		this.hasZipper = hasZipper;
	}

	@Override
	public int compareTo(PieceOfClothe arg0) {
		 return (int) ((this.getPrice()-arg0.getPrice())*200);
	}
	
}
