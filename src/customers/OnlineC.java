package customers;

import java.util.Random;

import clothes.PieceOfClothe;
import shops.*;
import workers.*;

public class OnlineC extends Customer implements ICanShopOnline {

	private static final double PERCENTAGE_OF_THE_TIP = 0.02;
	private static final int MIN_DISCOUNT_PROMO_CODE = 5;
	private static final int MAX_DISCOUNT_PROMO_CODE = 10;
	private static final int MIN_NUMBER_BOUGHT_CLOTHES = 3;
	private static final int MAX_NUMBER_BOUGHT_CLOTHES = 5;
	private boolean usedPromoCode = false;

	public OnlineC(String name, String phone, float money) {
		super(name, phone, money);
	}

	private float usePromoCode() {
		usedPromoCode = true;
		float cod=(float) ((int) (Math.random() * (MAX_DISCOUNT_PROMO_CODE - MIN_DISCOUNT_PROMO_CODE + 1)
				+ MIN_DISCOUNT_PROMO_CODE) * 0.01);
		System.out.println("promo kod: "+cod*100+ "%");
		return cod;
	}

	@Override
	public void makeOnlineOrder(OnlineShop s) {
		
		Order newOrder = makeOrder();
		
		// izpolzvane na promo kod:
		useDiscount(newOrder);

		// sled kato sme napravili pory4kata se izpra6ta dostav4ik:
		Courier courier = s.getRandomCourier();
		courier.deliverOrder(s, newOrder);

		// pla6tane na dostav4ika:
		this.payTheCourierTip(courier, newOrder);

		// namalqme parite na klienta i dobavqme pory4kata v spisyka mu:
		addOrderToTheList(newOrder);

	}

	void useDiscount(Order newOrder) {
		if (!usedPromoCode) {
			float price = newOrder.getPriceOfTheOrder();
			newOrder.setPriceOfTheOrder(price - price * this.usePromoCode());
		}
	}

	@Override
	PieceOfClothe choosePieceOfClothe() {
		PieceOfClothe clothe = Shop.returnRandomClotheFromTheCatalogue();
		return clothe;
	}

	@Override
	int getNumberOfBoughtClothes() {
		return (int) (Math.random() * (MAX_NUMBER_BOUGHT_CLOTHES - MIN_NUMBER_BOUGHT_CLOTHES + 1)
				+ MIN_NUMBER_BOUGHT_CLOTHES);
	}

	private void payTheCourierTip(Courier courier, Order order) {
		float tip = tipSize(order);
		System.out.println("the tip size: " + tip);
		courier.setMoneyOborot(courier.getMoneyOborot() + tip);
		this.setMoney(this.getMoney() - tip);
	}

	float tipSize(Order order) {
		float tipPercentage=(float) (order.getPriceOfTheOrder() * PERCENTAGE_OF_THE_TIP);
		System.out.println("percentage of the tip: "+ PERCENTAGE_OF_THE_TIP*100 + "%");
				return tipPercentage;
	}

	@Override
	public void buyClothes(Shop shop) {
		//unsafe cast!!!
		this.makeOnlineOrder( ((NormalShop)shop).getOnlineShop());
	}

}
