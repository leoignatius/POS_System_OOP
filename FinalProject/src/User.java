import java.util.*;

public class User {
	Admin a;
	Random rand = new Random();
	Membership m;
	Stock s;
	Card c = new Card();
	IndonesianCard ic = new IndonesianCard();
	NonMember nm = new NonMember();
	Member mm = new Member();
	public ArrayList<Stock> stockList = new ArrayList<Stock>();
	public ArrayList<Card> cardlist = new ArrayList<Card>();
	public ArrayList<Payment> CurrentPayment = new ArrayList<Payment>();
	public ArrayList<Membership> MemberList = new ArrayList<Membership>();
	public ArrayList<Payment> PaymentList = new ArrayList<Payment>();
	Scanner scan = new Scanner(System.in);
	private String username;
	private String password;
	private String name;

//////////////////////////////////////////////////////////////////////////////////GETTER SETTER
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public User() {

	}

//////////////////////////////////////////////////////////////////////////////////MENU
	public int usermenu(String username) { // print pilihan menu untuk user
		int choice = 0;
		System.out.println("Welcome " + username + "\n");
		System.out.println("Menu : ");
		System.out.println("1. Payment");
		System.out.println("2. Stock");
		System.out.println("3. Membership");
		System.out.println("4. Log out");
		do {
			try {
				System.out.print(">> ");
				choice = scan.nextInt();
			} catch (Exception e) {
				choice = 0;
			}
			scan.nextLine();
			return choice;
		} while (choice < 1 || choice > 5);

	}

	public void paymentmenu() { //print menu payment
		int paymentmenuchoice;
		System.out.println("1. Make Payment");
		System.out.println("2. Check Payment");
		System.out.println("3. Back");
		do {
			try {
				System.out.print(">> ");
				paymentmenuchoice = scan.nextInt();
			} catch (Exception e) {
				paymentmenuchoice = 0;
			}
			scan.nextLine();
		} while (paymentmenuchoice < 1 || paymentmenuchoice > 3);
		switch (paymentmenuchoice) {
		case 1: {
			selectitem();
			break;
		}
		case 2: {
			cls();
			viewpastpayment();
			scan.nextLine();
			cls();
			break;
		}

		}
	}

//////////////////////////////////////////////////////////////////////////////////CODEGENERATOR

	private long membercode() { //generate code member
		long code = (long) (Math.random() * 100000 + 3333300000L); // generate 10 angka acak
		for (int i = 0; i < MemberList.size(); i++) {
			if (MemberList.get(i).getCode() == code) { // jika ada code yang sama maka akan generate code baru
				code = (long) (Math.random() * 100000 + 3333300000L);
			}
		}
		return code;
	}

	private long transactioncode() { //generate code transaction
		long code = (long) (Math.random() * 100000 + 32832000L); // generate 8 angka acak
		for (int i = 0; i < MemberList.size(); i++) {
			if (MemberList.get(i).getCode() == code) { // jika ada code yang sama maka akan generate code baru
				code = (long) (Math.random() * 100000 + 32305000L);
			}
		}
		return code;
	}

//////////////////////////////////////////////////////////////////////////////////VIEW
	public void viewcard() { //print tabel untuk seluruh kartu yang ada di arraylist cardlist
		System.out.println("CREDIT CARD LIST : ");
		if (cardlist.isEmpty()) {
			System.out.println("There is no card");
		} else {
			garis(54);
			System.out.printf("|   No |         Name         |         Type         |\n");
			garis(54);
			for (int i = 0; i < cardlist.size(); i++) {
				System.out.printf("|%5d.| %-20s | %-20s |\n", i + 1, cardlist.get(i).getName(),
						cardlist.get(i).getType());
			}
			garis(54);
		}
	}

	public void viewstock() { //print tabel untuk seluruh stock yang ada di arraylist stockList
		System.out.println("STOCK LIST : ");
		if (stockList.isEmpty()) {
			System.out.println("There is no stock");
		} else {
			garis(64);
			System.out.printf("|   No  |         Name          |   Amount   |      Price      |\n");
			garis(64);
			for (int i = 0; i < stockList.size(); i++) {
				System.out.printf("|%5d. |  %-20s | %-10d | %-14d  |\n", i + 1, stockList.get(i).getName(),
						stockList.get(i).getAmount(), stockList.get(i).getPrice());
			}
			garis(64);
		}
	}

	public void viewcurrentpurchase() { //print tabel untuk seluruh barang yang dibeli yang ada di arraylist CurrentPayment
		long totalpurchase = 0;
		cls();
		System.out.println("YOUR BASKET : ");
		if (CurrentPayment.isEmpty()) {
			System.out.println("There is no purchase yet");
		} else {
			garis(62);
			System.out.printf("|   No  |         Name         |  Quantity  |   Total Price  |\n");
			garis(62);
			for (int i = 0; i < CurrentPayment.size(); i++) {
				System.out.printf("|%5d. | %-20s | %-10d | %-14d |\n", i + 1, CurrentPayment.get(i).getName(),
						CurrentPayment.get(i).getQuantity(), CurrentPayment.get(i).getTotalprice());
			}
			garis(62);
			for(int i = 0 ; i < CurrentPayment.size();i++) {
				totalpurchase = totalpurchase +  CurrentPayment.get(i).getTotalprice();
			}
			System.out.println("TOTAL PURCHASE : " + totalpurchase);
		}
	}

	public void viewpastpayment() {  //print tabel untuk seluruh transasksi yang sudah dilakukan yang ada di arraylist PaymentList
		System.out.println("PAST PAYMENT : ");
		if (PaymentList.isEmpty()) {
			System.out.println("There is no purchase yet");
		} else {
			garis(49);
			System.out.printf("|   No  |         Code         |   Total Price  |\n");
			garis(49);
			for (int i = 0; i < PaymentList.size(); i++) {
				System.out.printf("|%5d. | %-20s | %-14d |\n", i + 1, PaymentList.get(i).getName(),
						PaymentList.get(i).getTotalprice());
			}
			garis(49);
		}

	}
/////////////////////////////////////////////////////////////////////////////////////ADD

	public void createmember() { // membuat member baru
		String name, phonennumber;
		long code;
		System.out.print("Name [ 0 to cancel ] : ");
		name = scan.nextLine();
		if(name.equals("0")) {
			return;
		}
		for(int i = 0; i < MemberList.size();i++) {
			if(MemberList.get(i).getName().equals(name)) {
				System.out.println("Member is already exist , member code is " + MemberList.get(i).getCode());
				scan.nextLine();
				return;
			}
		}
		System.out.print("Phone Number : ");
		phonennumber = scan.nextLine();
		code = membercode();
		MemberList.add(new Member(code, name, phonennumber));
		System.out.println("Member has been Registered!!!");
		System.out.printf("%s Your member code is %s", name, code);
		scan.nextLine();
	}

	private void selectitem() { //untuk pilihan make payment saat kita memilih barang yang mau dibeli
		int itemselect, itemquantity, m = 0;

		boolean stockisempty = false;
		cls();
		viewstock();
		for (int i = 0; i < stockList.size(); i++) {
			if (stockList.get(i).getAmount() == 0) {
				m++; 
			}
		}
		if (m == stockList.size()) {
			stockisempty = true; //jika seluruh stock memiliki quantity 0 maka stock akan dianggap habis
		}
		if (stockList.isEmpty() || stockisempty == true) {
			System.out.println("No item Available");
			if (!CurrentPayment.isEmpty()) { //jika barang habis tetapi sudah sempat memasukan barang ke basket maka dilanjutkan ke pembayaran
				System.out.println("Continue to Payment");
				scan.nextLine();
				pay();
			}
		} else {
			do {
				try {
					System.out.println("Please select which item you want to buy [ 0 to cancel ] : ");
					itemselect = scan.nextInt();
				} catch (Exception e) {
					itemselect = 0;
				}
				scan.nextLine();
				if(itemselect == 0) {
					return;
				}
			} while (itemselect < 1 || itemselect > stockList.size());
			do {
				System.out.println("Quantity : ");
				itemquantity = scan.nextInt();
				scan.nextLine();
			} while (itemquantity < 1 || itemquantity > stockList.get(itemselect - 1).getAmount());
			CurrentPayment.add(new Payment(itemquantity, stockList.get(itemselect - 1).getName(),
					itemquantity * stockList.get(itemselect - 1).getPrice())); 
			int newquantity = stockList.get(itemselect - 1).getAmount() - itemquantity;
			stockList.get(itemselect - 1).setAmount(newquantity); //quantity stock yang ada dikurangi quantity dari barang yang baru dipilih untuk dibeli
			System.out.println("Do you want to add another item?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int anotheritem;
			do {
				try {
					System.out.print(">> ");
					anotheritem = scan.nextInt();
				} catch (Exception e) {
					anotheritem = 0;
				}
				scan.nextLine();
			} while (anotheritem < 1 || anotheritem > 2);
			viewcurrentpurchase();
			if (anotheritem == 1) {
				selectitem();
			} else {
				pay();
			}
		}
		CurrentPayment.clear(); //jika pembelian sudah dilakukan maka CurrentPaymentnya dikosongkan untuk customer selanjutnya
	}

/////////////////////////////////////////////////////////////////////////////////////PAY

	private void pay() { //untuk proses pembayaran(Make Payment)saat sudah memilih barang 
		String member, tcc;
		boolean membercheck;
		long membernumber = 0, newtotal = 0, total = 0, tc = 0;
		int paymentmethod, cardchoice;
		
		for (int i = 0; i < CurrentPayment.size(); i++) { // arraylist current purchase
			total = total + CurrentPayment.get(i).getTotalprice();
		}
		do {
			membercheck = false;
			member = "";
			System.out.print("Do you have a member? [yes / no] : ");
			member = scan.nextLine();
		} while (!member.equals("yes") && !member.equals("no"));
		if (member.equals("yes")) {
			System.out.print("Please Input the member code : ");
			membernumber = scan.nextLong();
			scan.nextLine();
			for (int i = 0; i < MemberList.size(); i++) {
				if (MemberList.get(i).getCode() == membernumber) {
					membercheck = true;
				}

			}
			if (membercheck == true) {
				total = mm.discount(total);
				System.out.println("Member Exist, 5% Discount");
			} else {
				total = nm.discount(total);
				System.out.println("Member doesn't Exist, 2% Discount");
			}
		} else {
			total = nm.discount(total);
			System.out.println("Member doesn't Exist, 2% Discount");
		}
		System.out.println("Please Select Payment Method : ");
		System.out.println("1. Cash");
		System.out.println("2. Credit Card");
		do {
			try {
				System.out.print(">> ");
				paymentmethod = scan.nextInt();
			} catch (Exception e) {
				paymentmethod = 0;
			}
			scan.nextLine();
		} while (paymentmethod < 1 || paymentmethod > 2);
		if (paymentmethod == 1) {
			tc = transactioncode();
			tcc = tc + "";
			System.out.println("Total Price : " + total);
			System.out.println("Thank You for your purchase, the purcase code is " + tc);
			PaymentList.add(new Payment(0, tcc, total));
		} else {
			viewcard();
			do {
				try {
					System.out.print("Please choose The card that you want to use : ");
					cardchoice = scan.nextInt();
				} catch (Exception e) {
					cardchoice = 0;
				}
				scan.nextLine();
			} while (cardchoice < 1 || cardchoice > cardlist.size() + 1);
			for (Card c : cardlist) {
				if (cardlist.get(cardchoice - 1).getType().equals("national")) {
					ic.finaltotal();
					newtotal = ic.finaltotal(total);
					break;
				} else {
					c.finaltotal();
					newtotal = c.finaltotal(total);
					break;
				}
			}

			tc = transactioncode();
			System.out.println("Total Price : " + newtotal);
			System.out.println("Thank You for your purchase, the purcase code is  " + tc);
			tcc = tc + "";
			PaymentList.add(new Payment(0, tcc, newtotal));
		}
		scan.hasNextLine();
	}

//////////////////////////////////////////////////////////////////DECORATION
	protected void cls() { // cls
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	protected void garis(int panjang) {
		for (int i = 0; i < panjang; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
