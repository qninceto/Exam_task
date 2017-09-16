package workers;

import java.util.*;

import clothes.PieceOfClothe;
import shops.*;

public abstract class Seller extends BaicInfo {

	private float moneyOborot;
	private float salary;
	private List<PieceOfClothe> clothesSoldList = new ArrayList<>();
	private NormalShop shop;

	public Seller(String name, String phone, NormalShop shop) {
		super(name, phone);
		this.initializeSalary();
		this.setShop(shop);
	}
	
	private void initializeSalary() {
		this.setSalary((int)(Math.random()*201+700));
	}
	
	public abstract void addOborotPercentageToTheSalary(float orderPrice);

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		//validate!!
		this.salary = salary;
	}

	
	public  void sellOrder(Order newOrder) {
		System.out.println("sold by: " + this);
		for(PieceOfClothe p : newOrder.unmodifiableListOfClothes()) {
			Shop.removeClotheFromTheCatalogue(p);
			this.clothesSoldList.add(p);
			
		}
		this.shop.setCashDesk(this.shop.getCashDesk()+newOrder.getPriceOfTheOrder());
		addOborotPercentageToTheSalary(newOrder.getPriceOfTheOrder());
		this.moneyOborot +=newOrder.getPriceOfTheOrder();
	}



	 @Override
	public String toString() {
		return "Seller [getName()=" + getName() + ", getPhone()=" + getPhone() + ", moneyOborot=" + moneyOborot
				+ ", salary=" + salary + "]";
	}

	private  void setShop(NormalShop shop) {
		 //validate
		this.shop = shop;
	}
	
	}
