
public class Member extends Membership {

	public Member(long code, String name, String phone) {
		super(code, name, phone);
	}

	public Member() {

	}

	@Override
	public long discount(long total) { // jika memiliki member maka akan diskon 5%
		long newtotal = total * 95 / 100;
		return newtotal;
	}

}
