package demo;

import java.util.*;

import customers.*;
import shops.*;
import workers.*;

public class Demo {
	
	//exceptions and validations!!!
	//formatting of the floats!!!
	//logical errors check!!!
	
	public static void main(String[] args) {

		// create a shop//which creates an oline shop in the constructor:
		NormalShop myShop = new NormalShop("Modern taents", "0885 698 657");

		// create Sellers and Couriers and add them to the shop:
		for (int i = 0; i < 5; i++) {
			myShop.getOnlineShop().addCourier(new Courier("Courier" + i, "0883 698 52" + i));
		}

		for (int i = 0; i < 4; i++) {
			myShop.addSeller(new NormalSeller("Seller" + i, "0883 697 52" + i, myShop));
		}

		myShop.addSeller(new Manager("Manager", "0885 698 477", myShop));

		// create 100 random clothes and add them to the shops static catalogue:
		for (int i = 0; i < 100; i++) {
			Shop.addClotheToTheCatalogue(RabdomClothesCreator.randomClothesCreator());
		}

		// create random customers:
		List<Customer> listC = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			listC.add(new CasualC("casual" + i, "0885 698 47" + i, 300 + i * 30));
			listC.add(new OnlineC("online" + i, "0885 698 47" + i, 400 + i * 20));
			listC.add(new LoyalC("loyal" + i, "0885 698 47" + i, 500 + i));
		}

		// print the catalogue before selling any clothes:
		System.out.println("catalogue before selling clothes:");
		myShop.printTheCatalogue();

		// sell clothes:
		System.out.println("***************************** POKUPKI");
		for (Customer c : listC) {
			c.buyClothes(myShop);
		}
		System.out.println("----------------------------------------------------------------");
		
		// print the catalogue after seling clothes:
		System.out.println();
		System.out.println("catalogue after selling clothes:");
		myShop.printTheCatalogue();
		System.out.println("----------------------------------------------------------------");

		//print the money of the shop:
		System.out.println("----------------> CASH DESK");
		System.out.println("shop "+myShop.getCashDesk());
		System.out.println("online shop "+myShop.getOnlineShop().getCashDesk());
		System.out.println();
		
		//print the list of the couriers:
		myShop.getOnlineShop().printCouriersSortedBySoldClothes();
		
		//print the most sold clothe:
		Shop.getTheMostSoldClothe();
		
		//print the sellers:
		myShop.printSellersBySalary();
	
		//print the customer with the max amount paid for clothes:
		printCustomerWithMaxAmountPaidForClothes(listC);
		
		//print the customer with the max number of bought clothes:
		//tuka ne e mnogo to4no, ponezg=he ima mnogo klienti s ednakyv broj zakupeni drehi...
		printCustomerWithMaxNumberOfBoughtClothes(listC);
	
	}

	static void printCustomerWithMaxNumberOfBoughtClothes(List<Customer> listC) {
		System.out.println();
		System.out.println("-------------------***");
		SortedSet<Customer> maxNumber =new TreeSet<>((c1,c2)-> (int)((c1.getTotalNumberOfBoughtClothes()-c2.getTotalSumPaidForClothes())*100));
		maxNumber.addAll(listC);
		System.out.println("customer with the max number of bought clothes: " + maxNumber.last()+"---->"+maxNumber.last().getTotalNumberOfBoughtClothes());
		System.out.println("customer with the min number of bought clothes: " + maxNumber.first()+"---->"+maxNumber.first().getTotalNumberOfBoughtClothes());
	}

	static void printCustomerWithMaxAmountPaidForClothes(List<Customer> listC) {
		System.out.println();
		System.out.println("-------------------***");
		SortedSet<Customer> maxAmount =new TreeSet<>((c1,c2)-> (int)((c1.getTotalSumPaidForClothes()-c2.getTotalSumPaidForClothes())*100));
		maxAmount.addAll(listC);
		System.out.println("customer with the max amount paid for clothes: " + maxAmount.last()+"---->"+maxAmount.last().getTotalSumPaidForClothes());
		System.out.println("customer with the min amount paid for clothes: " + maxAmount.first()+"---->"+maxAmount.first().getTotalSumPaidForClothes());
	}

}
