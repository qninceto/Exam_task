package workers;

import java.util.*;

import shops.*;

public class Manager extends Seller {
	
	private static final float MANAGER_PERCENTAGE_ADD_TO_SALARY = 0.05f;


	public Manager(String name, String phone, NormalShop shop) {
		super(name, phone,shop);
	}

	public float giveScrachCard() {
		return (float) ((new Random().nextInt(11))*0.01);
	}

	@Override
	public void addOborotPercentageToTheSalary(float orderPrice) {
		this.setSalary((float) (this.getSalary()+ MANAGER_PERCENTAGE_ADD_TO_SALARY*orderPrice));
	}

	@Override
	public void sellOrder(Order newOrder) {
		float discount = this.giveScrachCard();
		System.out.println("scratch card of " + discount*100+"% given from the manager");
		newOrder.setPriceOfTheOrder(newOrder.getPriceOfTheOrder()-newOrder.getPriceOfTheOrder()*discount);
		super.sellOrder(newOrder);
	}
}
