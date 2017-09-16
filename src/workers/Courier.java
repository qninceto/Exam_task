package workers;

import java.util.*;

import clothes.PieceOfClothe;
import customers.*;
import shops.*;

public class Courier extends BaicInfo {

	private float moneyOborot;
	private List<Order> spisykPorychi = new ArrayList<>();
	private int soldClothesCounter;

	public Courier(String name, String phone) {
		super(name, phone);
	}

	public float getMoneyOborot() {
		return moneyOborot;
	}

	public void setMoneyOborot(float moneyOborot) {
		this.moneyOborot = moneyOborot;
	}

	public void deliverOrder(Shop shop, Order newOrder) {
		System.out.println("delivered by: " + this);
		for (PieceOfClothe p : newOrder.unmodifiableListOfClothes()) {
			soldClothesCounter++;
			Shop.removeClotheFromTheCatalogue(p);
		}
		shop.setCashDesk(shop.getCashDesk() + newOrder.getPriceOfTheOrder());
		spisykPorychi.add(newOrder);
	}

	public int getSoldClothesCounter() {
		return soldClothesCounter;
	}

	@Override
	public String toString() {
		return "Courier [getName()=" + getName() + ", getPhone()=" + getPhone() + ", moneyOborot=" + moneyOborot
				+ ", soldClothesCounter=" + soldClothesCounter + "]";
	}

}
