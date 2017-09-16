package customers;

import java.util.*;

import clothes.PieceOfClothe;
import shops.*;

public abstract class Customer extends BaicInfo {

	private float money;
	private List<Order> listOrders = new ArrayList<>();
	private static int boughtVClothesCounter = 1;
	private float totalSumPaidForClothes;
	private int totalNumberOfBoughtClothes;

	public Customer(String name, String phone, float money) {
		super(name, phone);
		this.setMoney(money);
	}


	void addOrder(Order o) {
		if (o != null) {
			listOrders.add(o);
		}
		// else throw exception
	}

	Order makeOrder() {
		System.out.println();
		System.out.println(this + " is shopping ");
		Order newOrder = new Order(this, "jhfkjhadkf FBSDHR");// toz adres e smotan, ma ko da napraq...
		float virtualMoney = this.getMoney();

		/// loop:
		int numberOfBoughtClothes = getNumberOfBoughtClothes();
		for (int i = 0; i < numberOfBoughtClothes; i++) {
			// izbiram dreha:
			PieceOfClothe clothe = choosePieceOfClothe();
			if (clothe != null) {
				System.out.println(
						boughtVClothesCounter++ + ". chosen: " + clothe.getType() + " " + clothe.getSubtype() + " " + clothe);

				// ako imam pari q dobavqm kym current order:
				if (virtualMoney >= clothe.getPrice()) {
					newOrder.addClothe(clothe);
					virtualMoney -= clothe.getPrice();

				} else {
					System.out.println("ne stigat kintite za taz dreha...");
				}
			}
		}
		System.out.println("*****************************");
		return newOrder;
	}

	void addOrderToTheList(Order newOrder) {
		this.setMoney(this.getMoney() - newOrder.getPriceOfTheOrder());
		System.out.println("price of the order: "+ newOrder.getPriceOfTheOrder());
		System.out.println("ostanaha mu tolkoz pari: "+ money);
		this.totalSumPaidForClothes += newOrder.getPriceOfTheOrder();
		this.totalNumberOfBoughtClothes += newOrder.getNumberOfClothes();
		this.addOrder(newOrder);
	}

	abstract PieceOfClothe choosePieceOfClothe();

	abstract int getNumberOfBoughtClothes();

	public abstract void buyClothes(Shop s);

	@Override
	public String toString() {
		return getName() + ", getPhone()=" + getPhone() + ", money=" + money;
	}
	
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		// validate!
		this.money = money;
	}

	public float getTotalSumPaidForClothes() {
		return totalSumPaidForClothes;
	}

	public int getTotalNumberOfBoughtClothes() {
		return totalNumberOfBoughtClothes;
	}

}
