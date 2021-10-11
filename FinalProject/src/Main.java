import java.util.*;

public class Main {
	int welcomechoice;
	Scanner scan = new Scanner(System.in);
	boolean usernamecheck, checkpassword;
	String companyname, username, password, name;
	int x, usernameIndex;
	User u = new User();
	Admin a = new Admin();

	public Main() {
		initialize();
		System.out.print("Please Enter Your company's name : ");
		companyname = scan.nextLine();
		cls();
		do {
			WelcomePage();
		} while (welcomechoice != 1);
	}

	public static void main(String[] args) {
		new Main();

	}

	private void initialize() { // untuk initialize isi dari arraylist agar tidak kosong //hapus jika mau
								// mengkosongkan semua arraylist
		User u = new User("admin", "admin", "admin");
		a.adduseri(u);
		Card c = new Card("national", "BRI");
		a.addcardi(c);
		c = new Card("national", "MANDIRI");
		a.addcardi(c);
		c = new Card("national", "BCA");
		a.addcardi(c);
		c = new Card("national", "BNI");
		a.addcardi(c);
		c = new Card("international", "AMERICAN EXPRESS");
		a.addcardi(c);
		a.addstocki(new Stock("BESI", 100, 200000, 0));
		a.addstocki(new Stock("SENG", 100, 20000, 0));

	}

	public String username() {
		return username;
	}
	
	private void WelcomePage() { // print loginpage
		username = "";
		int choice;
		System.out.println("Welcome to " + companyname);
		System.out.println("1. Log In");
		System.out.println("2. Register");
		do {
			try {

				System.out.print(">> ");
				welcomechoice = scan.nextInt();
			} catch (Exception e) {
				welcomechoice = 0;
			}
			scan.nextLine();
		} while (welcomechoice < 1 || welcomechoice > 2);
		cls();
		if (welcomechoice == 1) {
			System.out.println("Username & Password : admin ( untuk menjadi admin ) ");
			login();
			
			if (!username.equals("admin")) {
				do {
					choice = u.usermenu(username);
					switch (choice) {
					case 1: {
						cls();
						a.paymentmenu();
						cls();
						break;
					}
					case 2: {
						cls();
						a.viewstock();
						scan.nextLine();
						cls();
						break;
					}
					case 3: {
						cls();
						a.createmember();
						cls();
						break;
					}
					case 4: {
						cls();
						do {
							WelcomePage();
						} while (welcomechoice != 1);
						cls();
						break;
					}

					}
				} while (choice != 5);
			} else {
				do {
					choice = a.usermenu(username);

					switch (choice) {
					case 1: {
						cls();
						a.paymentmenu();
						cls();
						break;
					}
					case 2: {
						cls();
						a.stockmenu();
						cls();
						break;
					}
					case 3: {
						cls();
						a.membershipmenu();
						cls();
						break;
					}
					case 4: {
						cls();
						a.deleteuser();
						cls();
						break;
					}
					case 5: {
						cls();
						a.cardmenu();
						cls();
						break;
					}
					case 6: {
						cls();
						do {
							WelcomePage();
						} while (welcomechoice != 1);
						cls();
						break;
					}

					}
				} while (choice != 7);
			}

		} else if (welcomechoice == 2) {
			register();
			cls();
		}
	}

	private int checkusername(String username) { // check apakah username sudah ada
		usernamecheck = false;
		x = 0;
		for (int i = 0; i < a.UserList.size(); i++) {
			usernamecheck = a.UserList.get(i).getUsername().equals(username);
			if (usernamecheck == true) {
				x = 1;
			}
		}
		return x;
	}

	private int checkusernameindex(String username) { // mengecheck index dari username yang sudah di input
		for (int i = 0; i < a.UserList.size(); i++) {
			usernamecheck = a.UserList.get(i).getUsername().equals(username);
			if (usernamecheck == true) {
				usernameIndex = i;
			}
		}
		return usernameIndex;
	}

	private void login() { // menu login
		int m;
		do {
			usernamecheck = false;
			m = 0;
			username = "";
			System.out.print("Please Enter Your Username [ 0 to cancel ] : ");
			username = scan.nextLine();
			m = checkusername(username);
			if (username.equals("0")) {
				cls();
				WelcomePage();
			} else {
				if (m != 1) {
					System.out.println("Username Not Found !!!");
				}
			}

		} while (m != 1 && !username.equals("0"));
		int usernameIndex = checkusernameindex(username);
		do {
			checkpassword = false;
			password = "";
			System.out.print("Please Enter Your Password : ");
			password = scan.nextLine();
			if (password.equals(a.UserList.get(usernameIndex).getPassword())) {
				checkpassword = true;
			}
		} while (checkpassword == false);
		cls();

	}

	private void register() { // menu register
		String regusername;
		System.out.print("Please Input your Name [ 0 to cancel ] : ");
		name = scan.nextLine();
		if (name.equals("0")) {
			cls();
			return;
		}
		do {
			System.out.print("Please Input your Username : ");
			regusername = scan.nextLine();
			x = 0;
			checkusername(regusername);
			if (x == 1) {
				System.out.println("Username is Already Taken !!!");
			}
		} while (x == 1);
		System.out.print("Please Input your Password : ");
		password = scan.nextLine();
		u = new User(regusername, password, name);
		a.UserList.add(u);
		System.out.println("You have been registered!!!");
		welcomechoice = 0;
		scan.nextLine();
		cls();
		WelcomePage();
	}

	private void cls() { // cls
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
