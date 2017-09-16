package clothes;

import java.util.Random;

import clothes.SwimmingSuite.SSType;

public class Pants extends PieceOfClothe implements Comparable<PieceOfClothe> {

	@Override
	public String toString() {
		return super.toString() + " [shirochina=" + shirochina + ", dylzhina=" + dylzhina + "]";
	}

	public enum PantsType implements SubtypeClothing {
		DENIM, STRAIGHT, SHORT
	}

	private float shirochina;
	private float dylzhina;

	public Pants(char size, String description, float price, PantsType subType, float shirochina, float dylzhina) throws Exception {
		super(size, description, price, subType, TypeClothing.PANTS);
		this.shirochina = shirochina;///setter!!!
		this.dylzhina = dylzhina;///setter!!!
	}

	@Override
	public int compareTo(PieceOfClothe o) {
		if (this.shirochina == ((Pants) o).shirochina)
			return (int) ((this.dylzhina - ((Pants) o).dylzhina) * 100);
		// unsafe downcast?????
		return (int) ((this.shirochina - ((Pants) o).shirochina) * 100);
	}

}
