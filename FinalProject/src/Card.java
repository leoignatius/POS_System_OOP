
public class Card implements Interest, Runnable {

	private String type;
	private String name;

	public Card() {
		// TODO Auto-generated constructor stub

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	@Override
	public long finaltotal(long total) {
		long newtotal = total + (total * 5 / 100); // jika menggunakan kartu kredit National akan dikenakan bunga
													// sebesar 5%
		return newtotal;
	}

	@Override
	public long finaltotal() {
		System.out.println("Generating Total with International Rate, Please Wait");
		try {
			Thread.sleep(2000); // akan delay selama 2000 milisecond / 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
