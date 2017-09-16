package workers;

import shops.*;

public class NormalSeller extends Seller {
	
	
	private static final float SELLER_PERCENTAGE_ADD_TO_SALARY = 0.03f;

	public NormalSeller(String name, String phone, NormalShop shop) {
		super(name, phone, shop);
	}

	@Override
	public void addOborotPercentageToTheSalary(float orderPrice) {
		this.setSalary((float) (this.getSalary()+ SELLER_PERCENTAGE_ADD_TO_SALARY*orderPrice));
	}

	
}
