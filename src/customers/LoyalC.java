package customers;

import java.util.Random;

import shops.*;
import workers.Seller;

public class LoyalC extends OnlineC implements ICanShopCasual {

	private static final double CHANE_TO_SHOP_ONLINE = 0.5;
	private static final double PERCENTAGE_OF_THE_TIP = 0.05;
	private static final int MIN_NUMBER_BOUGHT_CLOTHES = 4;
	private static final int MAX_NUMBER_BOUGHT_CLOTHES = 6;

	public LoyalC(String name, String phone, float money) {
		super(name, phone, money);
	}

	private float getDiscount(Order order) {
		if (order.getPriceOfTheOrder() > 50)
			return 0.15f;
		return 0.1f;
	}

	@Override
	int getNumberOfBoughtClothes() {
		return new Random().nextInt(MAX_NUMBER_BOUGHT_CLOTHES - MIN_NUMBER_BOUGHT_CLOTHES + 1)
				+ MIN_NUMBER_BOUGHT_CLOTHES;

	}

	void useDiscount(Order newOrder) {
		float price = newOrder.getPriceOfTheOrder();
		System.out.println("percentage of the discount "+ this.getDiscount(newOrder)*100+ "%");
		newOrder.setPriceOfTheOrder(price - price * this.getDiscount(newOrder));
	}

	@Override
	float tipSize(Order order) {
		return (float) (order.getPriceOfTheOrder() * PERCENTAGE_OF_THE_TIP);
	}

	@Override
	// kak da izbegna tova povtorenie na kod?????
	public void makeCasualOrder(NormalShop s) {

		Order newOrder = makeOrder();

		// sled kato sme napravili pory4kata izvikvame prodava4a:
		Seller seller = s.getRandomSeller();
		seller.sellOrder(newOrder);

		// namalqme parite na klienta i dobavqme pory4kata v spisyka mu:
		addOrderToTheList(newOrder);
	}

	@Override
	public void buyClothes(Shop shop) {
		if (Math.random() <= CHANE_TO_SHOP_ONLINE) {
			// unsafe cast!!!
			this.makeCasualOrder((NormalShop) shop);
		} else {
			// unsafe cast!!!
			this.makeOnlineOrder(((NormalShop) shop).getOnlineShop());
		}
	}
}
