package shops;

import java.time.LocalDateTime;
import java.util.*;

import clothes.PieceOfClothe;
import customers.Customer;

public class Order {
	private Customer customer;
	private float priceOfTheOrder;
	private String AddressOfDelivery;
	private LocalDateTime dateAndTimeOfDelivery;
	private int numberOfClothes;

	private List<PieceOfClothe> spisykSDrehiVPorychkata = new ArrayList<>();

	public Order(Customer customer, String addressOfDelivery) {
		this.setCustomer(customer);
		this.setAddressOfDelivery(addressOfDelivery);
		this.dateAndTimeOfDelivery = LocalDateTime.now();
	}

	public float getPriceOfTheOrder() {
		return priceOfTheOrder;
	}

	public void addClothe(PieceOfClothe clothe) {
		if (clothe != null) {
			spisykSDrehiVPorychkata.add(clothe);
			this.numberOfClothes++;
			priceOfTheOrder += clothe.getPrice();
		}
	}

	public int getNumberOfClothes() {
		return numberOfClothes;
	}

	public void setPriceOfTheOrder(float priceOfTheOrder) {
		//validate!!!!!
		this.priceOfTheOrder = priceOfTheOrder;
	}

	public List<PieceOfClothe> unmodifiableListOfClothes(){
		return Collections.unmodifiableList(spisykSDrehiVPorychkata);
	}

	private void setCustomer(Customer customer) {
		//validate
		this.customer = customer;
	}



	private void setAddressOfDelivery(String addressOfDelivery) {
		//validate
		AddressOfDelivery = addressOfDelivery;
	}

	
}
