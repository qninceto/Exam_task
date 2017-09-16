package shops;

import java.util.*;

import workers.Courier;
import workers.Seller;

public class OnlineShop extends Shop {

	private List<Courier> listCouriers = new ArrayList<>();

	public OnlineShop(String name, String phone) {
		super(name, phone);
	}

	public void addCourier(Courier c) {
		if (c != null)
			listCouriers.add(c);
		// else
		// throw exception
	}

	public Courier getRandomCourier() {
		return listCouriers.get(new Random().nextInt(listCouriers.size()));
	}

	public void printCouriersSortedBySoldClothes() {
		System.out.println("LIST OF COURIERS ------> sorted by number of sold goods");
		// option 1 ----> lambda:
		Collections.sort(listCouriers, (o1, o2) -> o2.getSoldClothesCounter() - o1.getSoldClothesCounter());

		// option 2 ---->anonimous class:
		// Collections.sort(listCouriers, new Comparator<Courier>() {
		//
		// @Override
		// public int compare(Courier arg0, Courier arg1) {
		// return arg1.getSoldClothesCounter()-arg0.getSoldClothesCounter();
		// }
		//
		// });

		// option 3 ---->>???--- cannot be descending???
		// listCouriers.sort(Comparator.comparing(Courier::getSoldClothesCounter));
		for (Courier c : listCouriers) {
			System.out.println(c);
		}
	}

}
