package clothes;

import java.util.Comparator;


public class PriceComparator implements Comparator<PieceOfClothe>{

	@Override
	public int compare(clothes.PieceOfClothe o1, clothes.PieceOfClothe o2) {
		// TODO Auto-generated method stub
		return (int) ((o1.getPrice()-o2.getPrice())*200);
	}

}
