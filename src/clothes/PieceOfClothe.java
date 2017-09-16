package clothes;

public abstract class PieceOfClothe {

	public enum TypeClothing {
		DRESS, JACKET, PANTS, SWIMMING_SUITE
	}

	private char size;
	private String description;
	private float price;
	private SubtypeClothing subtype;
	private TypeClothing type;

	public PieceOfClothe(char size, String description, float price, SubtypeClothing type, TypeClothing vid) throws Exception {
		this.setSize(size);
		this.setDescription(description);
		this.setPrice(price);
		this.subtype = type;
		this.type = vid;
	}

	@Override
	public String toString() {
		return " [size=" + size + ", description=" + description + ", price=" + price + "]";
	}

	public float getPrice() {
		return price;
	}

	public SubtypeClothing getSubtype() {
		return subtype;
	}

	public TypeClothing getType() {
		return type;
	}

	private void setPrice(float price) throws Exception {
		if (price >= 0) {
			this.price = price;
		}else {
			throw new Exception("invalid price");
		}

	}

	private void setDescription(String description) {
		// validate+exception
		this.description = description;
	}

	private void setSize(char size) {
		// validate+exception
		this.size = size;
	}
}
