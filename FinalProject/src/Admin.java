import java.util.*;

public class Admin extends User {
	public ArrayList<User> UserList = new ArrayList<User>();
	
	
	User us;

	public Admin(String username, String password, String name) {
		super(username, password, name);

	}

	public Admin() {

	}

//////////////////////////////////////////////////////////////////DELETE
	public void deleteuser() { //untuk delete user
		PrintUserList();
		if (UserList.size() == 1) {
			System.out.println("There is no User");
			scan.nextLine();
			return;
		}
		int index;
		do {
			try {
				System.out.print("Please Choose the user that you want to delete [ 0 to cancel ] : ");
				index = scan.nextInt();
			} catch (Exception e) {
				index = 0;
			}
			scan.nextLine();
			if (index == 1) {
				System.out.println("You Cannot remove Admin!!!");
			}
			if (index == 0) {
				return;
			}

		} while (index < 1 || index > UserList.size() || index == 1);

		UserList.remove(index - 1);
		System.out.println("This user has been deleted!!!");
		scan.nextLine();
	}

	public void removeStock() { //untuk remove stock dari stock	list
		viewstock();
		if (stockList.isEmpty()) {
			System.out.println("There is no stock");
			scan.nextLine();
			return;
		}
		int index;
		do {
			try {
				System.out.print("Please Choose Stock that you want to delete [ 0 to cancel ] : ");
				index = scan.nextInt();
			} catch (Exception e) {
				index = 999;
			}
			scan.nextLine();
			if(index == 0) {
				return;
			}
		} while (index < 1 || index > stockList.size());

		stockList.remove(index - 1);
		System.out.println("Stock has been deleted!!!");
		scan.nextLine();

	}

	private void deletemember() { // delete member dari membership list
		printmemberlist();
		if (MemberList.isEmpty()) {
			System.out.println("There is no member ");
			scan.nextLine();
			return;
		}
		int index;
		do {
			try {
				System.out.print("Please select member that you want to delete [ 0 to cancel ] : ");
				index = scan.nextInt();
			} catch (Exception e) {
				index = 999;
			}
			scan.nextLine();
			if(index == 0) {
				return;
			}
		} while (index < 1 || index > MemberList.size());

		MemberList.remove(index - 1);
		System.out.println("Member has been deleted");
		scan.nextLine();
	}

	private void removecard() { // delete card dari card list
		viewcard();
		if (cardlist.isEmpty()) {
			System.out.println("There is no card");
			scan.nextLine();
			return;
		}
		int index;
		do {
			try {
				System.out.print("Choose Bank that you want to delete [ 0 to cancel ] : ");
				index = scan.nextInt();
			} catch (Exception e) {
				index = 999;
			}
			scan.nextLine();
			if(index == 0) {
				return;
			}
		} while (index < 1 || index > cardlist.size());

		cardlist.remove(index - 1);
		System.out.println("This bank has been removed!!!");
		scan.nextLine();
	}

//////////////////////////////////////////////////////////////////MENU
	@Override
	public int usermenu(String username) { //menu untuk user
		int choice;
		System.out.println("Welcome " + username + "\n");
		System.out.println("Menu : ");
		System.out.println("1. Payment");
		System.out.println("2. Stock");
		System.out.println("3. Membership");
		System.out.println("4. Remove User");
		System.out.println("5. Card");
		System.out.println("6. Log out");
		do {
			try {
				System.out.print(">> ");
				choice = scan.nextInt();
			} catch (Exception e) {
				choice = 0;
			}
			scan.nextLine();
			return choice;
		} while (choice < 1 || choice > 6);

	}

	public void stockmenu() { //menu untuk pilihan stock pada menu admin
		int stockchoice;
		System.out.println("1. Check Stock");
		System.out.println("2. Add Stock");
		System.out.println("3. Remove Stock");
		System.out.println("4. Back");
		do {
			try {
				System.out.print(">> ");
				stockchoice = scan.nextInt();
			} catch (Exception e) {
				stockchoice = 0;
			}
			scan.nextLine();
		} while (stockchoice < 1 || stockchoice > 4);
		switch (stockchoice) {
		case 1: {
			cls();
			viewstock();
			scan.nextLine();
			cls();
			break;
		}
		case 2: {
			cls();
			addStock();
			cls();
			break;
		}
		case 3: {
			cls();
			removeStock();
			cls();
			break;
		}

		}
	}

	public void membershipmenu() { //untuk menu membership pada menu admin
		int membershipchoice;
		System.out.println("1. Make membership");
		System.out.println("2. See all membership");
		System.out.println("3. Remove membership");
		System.out.println("4. Back");
		do {
			try {
				System.out.print(">> ");
				membershipchoice = scan.nextInt();
			} catch (Exception e) {
				membershipchoice = 0;
			}
			scan.nextLine();
		} while (membershipchoice < 1 || membershipchoice > 4);
		switch (membershipchoice) {
		case 1: {
			cls();
			createmember();
			break;
		}
		case 2: {
			cls();
			printmemberlist();
			scan.nextLine();
			break;
		}
		case 3: {
			cls();
			deletemember();
			break;
		}
		}

	}

	public void cardmenu() { //untuk menu card pada menu admin
		int cardmenuchoice;

		System.out.println("1. View Card List");
		System.out.println("2. Add Card");
		System.out.println("3. Remove Card");
		System.out.println("4. Back");
		do {
			try {
				System.out.print(">> ");
				cardmenuchoice = scan.nextInt();
			} catch (Exception e) {
				cardmenuchoice = 0;
			}
			scan.nextLine();
		} while (cardmenuchoice < 1 || cardmenuchoice > 4);
		switch (cardmenuchoice) {
		case 1: {
			cls();
			viewcard();
			scan.nextLine();
			cls();
			break;
		}
		case 2: {
			cls();
			addcard();
			cls();
			break;
		}
		case 3: {
			cls();
			removecard();
			cls();
			break;
		}

		}
	}

//////////////////////////////////////////////////////////////////VIEW

	private void printmemberlist() { //print semua member pada memberlist
		if (MemberList.isEmpty()) {
			System.out.println("There is no member yet!!!");
		} else {
			garis(62);
			System.out.printf("|   No  |    Code    |         Name         |  Phone Number  |\n");
			garis(62);
			for (int i = 0; i < MemberList.size(); i++) {
				System.out.printf("|%5d. | %-10d | %-20s | %-14s |\n", i + 1, MemberList.get(i).getCode(),
						MemberList.get(i).getName(), MemberList.get(i).getPhone());

			}
			garis(62);
		}

	}

	public void PrintUserList() { //print semua user pada userlist
		garis(66);
		System.out.printf("|   No  |         Name         |    Username    |    Password    |\n");
		garis(66);
		for (int i = 0; i < UserList.size(); i++) {
			System.out.printf("|%5d. | %-20s | %-14s | %-14s |\n", i + 1, UserList.get(i).getName(),
					UserList.get(i).getUsername(), UserList.get(i).getPassword());
		}
		garis(66);
	}

//////////////////////////////////////////////////////////////////ADD

	public void addStock() { //untuk add stock pada menu stock di menu admin
		String name;
		int price = 0, amount = 0;
		int stockexist = 0;
		int totalPrice = amount * price;
		do {
			System.out.print("Insert Stock name [ 0 to cancel ] : ");
			name = scan.nextLine();
		} while (name.length() < 1);
		if(name.equals("0")) {
			return;
		}
		stockexist = stockvalidator(name);
		do {
			try {
				System.out.print("Insert amount of stock : ");
				amount = scan.nextInt();
			} catch (Exception e) {
				amount = 0;
			}
			scan.nextLine();
		} while (amount < 1);
		if (stockexist != -1) {
			stockList.get(stockexist).setAmount(stockList.get(stockexist).getAmount() + amount);
		} else {
			do {
				System.out.print("Insert price of item : ");
				price = scan.nextInt();
				stockList.add(new Stock(name, amount, price, totalPrice));
				scan.nextLine();
			} while (price < 1);
		}
		System.out.println("Stock added!");
		scan.nextLine();
	}

	public void addcard() { //untuk add card pada menu card di menu admin
		String bankname, banktype;
		int check;
		do {
			check = 0;
			System.out.print("Enter Bank Name [ 0 to cancel ]:");
			bankname = scan.nextLine();
			if(bankname.equals("0")) {
				return;
			}
			for (int i = 0; i < cardlist.size(); i++) {
				if (cardlist.get(i).getName().equals(bankname)) {
					check = 1;
					System.out.println("This Bank is Already in the System, Please Input Other Bank");
				}
			}
		} while (check == 1);
		do {
			System.out.print("Please Choose the card type [national / international] : ");
			banktype = scan.nextLine();
		} while (!banktype.equals("national") && !banktype.equals("international"));
		cardlist.add(new Card(banktype, bankname));
		System.out.println("Bank has been registered!!!");
		scan.nextLine();
	}

	public void addcardi(Card c) { //untuk add card pada initialize() di user
		cardlist.add(c);
	}

	public void adduseri(User u) { //untuk add user pada initialize() di user
		UserList.add(u);
	}
	
	public void addstocki(Stock s) { //untuk add stock pada initialize() di user
		stockList.add(s);
	}

//////////////////////////////////////////////////////////////////VALIDATOR
	private int stockvalidator(String names) { //untuk mengecheck apakah stock dengan yang nama sama sudah ada atau belum
		int exist = -1;
		for (int i = 0; i < stockList.size(); i++) {
			if (stockList.get(i).getName().equals(names)) {
				exist = i;
				break;
			}
		}
		return exist;
	}

}
