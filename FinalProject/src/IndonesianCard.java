
public class IndonesianCard extends Card{

	
	public IndonesianCard(String type, String name) {
		super(type, name);
	}

	
	@Override
	public long finaltotal(long total) { // jika menggunakan kartu kredit National akan dikenakan bunga sebesar 3%
		long newtotal  = total + (total * 3 /100);
		return newtotal;
	}

	@Override
	public long finaltotal() {
		System.out.println("Generating Total with National Rate, Please Wait");
        try {
			Thread.sleep(2000); //akan delay selama 2000 milisecond / 2 seconds
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
	public IndonesianCard() {

	}

}
