package demo;

import java.util.Random;

import clothes.*;
import clothes.Dress.DressType;
import clothes.Jacket.JacketType;
import clothes.Pants.PantsType;
import clothes.SwimmingSuite.SSType;

public class RabdomClothesCreator {

	public static PieceOfClothe randomClothesCreator() {
		char[] sizes = new char[] { 'S', 'M', 'L' };
		char size = sizes[new Random().nextInt(sizes.length)];
		String description = "bla bla";
		float price = new Random().nextFloat() * 50;// ???
		boolean randomBoolean = Math.random() > 0.5 ? true : false;

		float clothesTypeChance = (float) Math.random();

		if (clothesTypeChance <= 0.25) {
			int parts = new Random().nextInt(3) + 1;
			return new SwimmingSuite(size, description, price,
					SSType.values()[new Random().nextInt(SSType.values().length)], parts);// kak da mahna tova
																							// povtorenie na kod?
		}

		if (clothesTypeChance <= 0.5) {
			return new Dress(size, description, price,
					DressType.values()[new Random().nextInt(DressType.values().length)], randomBoolean);
		}

		if (clothesTypeChance <= 0.75) {
			return new Jacket(size, description, price,
					JacketType.values()[new Random().nextInt(JacketType.values().length)], randomBoolean);
		}
		
		int shirochina = new Random().nextInt(30);//?
		int dylzhina = new Random().nextInt(100);//?
		return new Pants(size, description, price, PantsType.values()[new Random().nextInt(PantsType.values().length)],
				shirochina, dylzhina);

	}
	

}
