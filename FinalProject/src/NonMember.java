
public class NonMember extends Membership {

	public NonMember() {

	}

	public NonMember(long code, String name, String phone) {
		super(code, name, phone);
	}

	@Override
	public long discount(long total) { // jika tidak memiliki member maka akan diskon 2%
		long newtotal = total * 98 / 100;
		return newtotal;
	}

}
