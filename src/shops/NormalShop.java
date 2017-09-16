package shops;

import java.util.*;

import workers.*;

public class NormalShop extends Shop {
	private List<Seller> listSellers = new ArrayList<Seller>();
	private OnlineShop onlineShop;

	// private Set<Seller> listSellers = new TreeSet<Seller>(new PriceComparator());

	public NormalShop(String name, String phone) {
		super(name, phone);
		onlineShop = new OnlineShop(name, phone);
	}

	public void addSeller(Seller s) {
		if (s != null)
			listSellers.add(s);
		// else
		// throw exception
	}

	public OnlineShop getOnlineShop() {
		return onlineShop;
	}

	public Seller getRandomSeller() {

		return listSellers.get(new Random().nextInt(listSellers.size()));
	}

	public void printSellersBySalary() {
		System.out.println("LIST OF SELLERS ------> sorted by salary");
		Collections.sort(listSellers, (o1, o2) -> (int)((o1.getSalary() - o2.getSalary())*100));

		for (Seller c : listSellers) {
			System.out.println(c);
		}
	}
}
