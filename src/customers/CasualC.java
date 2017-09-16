package customers;

import java.util.Random;

import clothes.*;
import shops.*;
import workers.*;

public class CasualC extends Customer implements ICanShopCasual {

	private static final int MAX_NUMBER_BOUGHT_COTHES = 3;

	public CasualC(String name, String phone, float money) {
		super(name, phone, money);
	}

	@Override
	public void makeCasualOrder(NormalShop s) {
		
		Order newOrder = makeOrder();
		
		//sled kato sme napravili pory4kata izvikvame prodava4a:
		Seller seller = s.getRandomSeller();
		seller.sellOrder(newOrder);
		
		//namalqme parite na klienta i dobavqme pory4kata v spisyka mu:
		addOrderToTheList(newOrder);
		
	}
	
	@Override
	PieceOfClothe choosePieceOfClothe() {
		PieceOfClothe clothe = Shop.returnRandomNonNullClotheFromTheCatalogue();
		return clothe;
	}

	@Override
	int getNumberOfBoughtClothes() {
		return new Random().nextInt(MAX_NUMBER_BOUGHT_COTHES) + 1;
	}

	@Override
	public void buyClothes(Shop s) {
		//unsafe cast!!!
		this.makeCasualOrder((NormalShop)s);
	}
}
