
public class Payment {

	private int quantity;
	private String Name;
	private long totalprice;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public Payment(int quantity, String name, long newtotal) {
		super();
		this.quantity = quantity;
		Name = name;
		this.totalprice = newtotal;
	}

	public Payment() {

	}

}
