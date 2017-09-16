package shops;

public abstract class BaicInfo {
	private String name;
	private String phone;

	public BaicInfo(String name, String phone) {
		this.setName(name);
		this.setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// validate+exception
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		// validate+exception
		this.phone = phone;
	}
}
