
public abstract class Membership { //diinherit Member dan NonMember

	private long code;
	private String name;
	private String phone;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Membership(long code, String name, String phone) {
		super();
		this.code = code;
		this.name = name;
		this.phone = phone;
	}

	protected abstract long discount(long total); //abstract untuk Member dan NonMember

	public Membership() {

	}

}
