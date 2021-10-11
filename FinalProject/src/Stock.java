import java.util.*;

public class Stock {
	private String name;
	private int amount;
	private int price;
	private int totalPrice;
	Scanner scan = new Scanner(System.in);

	public Stock(String name, int amount, int price, int totalPrice) {
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPrice() { //untuk menghitung total harga 
		totalPrice = getPrice() * getAmount();
		return totalPrice;
	}

}