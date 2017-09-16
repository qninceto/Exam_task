package clothes;

import java.util.Random;

import clothes.PieceOfClothe.TypeClothing;

public class SwimmingSuite extends PieceOfClothe implements Comparable<PieceOfClothe> {

	@Override
	public String toString() {
		return super.toString() + " [numberParts=" + numberParts + "]";
	}


	public enum SSType implements SubtypeClothing {
		BLACK, WHITE, COLOR
	}

	private int numberParts;

	public SwimmingSuite(char size, String description, float price, SSType subType, int numberParts) {
		super(size, description, price, subType, TypeClothing.SWIMMING_SUITE);
		this.setNumberParts(numberParts);
	}

	private void setNumberParts(int numberParts) {
		///validate- no more than 3
		
		this.numberParts = numberParts;
	}


	@Override
	public int compareTo(PieceOfClothe o) {
		if(this.numberParts==((SwimmingSuite) o).numberParts)
			return (int) (this.getPrice()-((SwimmingSuite) o).getPrice());
		return this.numberParts - ((SwimmingSuite) o).numberParts;
	}

	

}
