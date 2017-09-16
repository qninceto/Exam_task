package shops;

import java.util.*;

import clothes.PieceOfClothe;
import clothes.PieceOfClothe.TypeClothing;
import clothes.SubtypeClothing;

public abstract class Shop extends BaicInfo {

	// naliva se tuk, kogato se izvezhda na ekrana???
	// vsichki drehi sortirani po vid, po tip i v treesetove po syotvetnite
	// kriterii:
	private static HashMap<TypeClothing, HashMap<SubtypeClothing, TreeSet<PieceOfClothe>>> catalogue = new HashMap<>();
	private float cashDesk;
	private static Map<TypeClothing, Integer> soldClothesByTypeStatistics = new HashMap<>();

	static {
		for (TypeClothing type : TypeClothing.values()) {
			soldClothesByTypeStatistics.put(type, 0);
		}
	}

	public Shop(String name, String phone) {
		super(name, phone);
	}

	public static void addClotheToTheCatalogue(PieceOfClothe c) {
		if (c != null) {
			TypeClothing type = c.getType();
			SubtypeClothing subtype = c.getSubtype();

			catalogue.putIfAbsent(type, new HashMap<>());
			catalogue.get(type).putIfAbsent(subtype, new TreeSet<>());
			catalogue.get(type).get(subtype).add(c);
		} else {
			// tova ne e dreha
		}
	}

	public static void removeClotheFromTheCatalogue(PieceOfClothe c) {
		if (c != null) {
			TypeClothing type = c.getType();
			SubtypeClothing subtype = c.getSubtype();

			if (!catalogue.containsKey(type) || !catalogue.get(type).containsKey(subtype)) {
				System.out.println("such piece of clothe doesnt exist");
				return;
			}
			// updates values in the statistics:
			int oldStatistics = soldClothesByTypeStatistics.get(type).intValue();
			soldClothesByTypeStatistics.put(type, ++oldStatistics);

			// removes from the catalogue:
			catalogue.get(type).get(subtype).remove(c);
		} else {
			// tova ne e dreha
		}
	}

	// for the online customers:
	public static PieceOfClothe returnRandomClotheFromTheCatalogue() {
		TypeClothing type = TypeClothing.values()[new Random().nextInt(TypeClothing.values().length)];
		/// downcast.....

		Object[] sub = catalogue.get(type).keySet().toArray();

		// System.out.println(Arrays.toString(sub));
		// SubtypeClothing[] sub = (SubtypeClothing[])
		// (catalogue.get(type).keySet().toArray());//????ne raboti???
		// vry6ta dreha ot proizvolen tip , no naj evtinata,6toto ne mi se zanimava da
		// napravq random
		// vry6ta null ako treesetyt e prazen!!!
		TreeSet<PieceOfClothe> clothes = catalogue.get(type)
				.get((SubtypeClothing) sub[new Random().nextInt(sub.length)]);
		if (clothes.isEmpty()) {
			System.out.println("drehata ot vid " + type + "i tip: " + " ne e nali4na");
		} else {

			PieceOfClothe c = clothes.first();
			return c;
		}

		return null;
	}

	public static PieceOfClothe returnRandomNonNullClotheFromTheCatalogue() {
		PieceOfClothe c = returnRandomClotheFromTheCatalogue();
		if (c == null) {
			while (c == null) {
				c = returnRandomClotheFromTheCatalogue();
			}
		}
		return c;
	}

	public static void printTheCatalogue() {
		int counter = 1;
		for (TypeClothing type : catalogue.keySet()) {
			System.out.println("-------------------->" + type + "<--------------------");
			for (SubtypeClothing subt : catalogue.get(type).keySet()) {
				System.out.println(subt);
				Set<PieceOfClothe> clothes = catalogue.get(type).get(subt);
				if (clothes.isEmpty()) {
					System.out.println("nqma nalichni brojki");
				} else {
					for (PieceOfClothe c : clothes) {
						System.out.println(counter++ + ". " + c);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public float getCashDesk() {
		return cashDesk;
	}

	public void setCashDesk(float cashDesk) {
		// validate
		this.cashDesk = cashDesk;
	}

	public static void printStatistics() {
		System.out.println();
		System.out.println("STATISTICS OF SOLD CLOTHES:");
		for (TypeClothing t : soldClothesByTypeStatistics.keySet()) {
			System.out.println(t + " --> " + soldClothesByTypeStatistics.get(t).intValue() + " pc.");
		}
	}

	public static void getTheMostSoldClothe() {
		printStatistics();

		TypeClothing maxSoldType = Collections
				.max(soldClothesByTypeStatistics.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
				.getKey();
		System.out.println("-------");
		System.out.println("max slod type: " + maxSoldType );
	}
}
