package llpackage;

public class Customer {

	private String first_name;
	private String last_name;
	private String company_name;
	private String address;
	private String city;
	private String county;
	private String state;
	private String zip;
	private String phone1;
	private String phone2;
	private String email;
	private String web;

	// Constructor with arguments
	public Customer(String first_name, String last_name, String company_name, String address, String city,
			String county, String state, String zip, String phone1, String phone2, String email, String web) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.company_name = company_name;
		this.address = address;
		this.city = city;
		this.county = county;
		this.state = state;
		this.zip = zip;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.web = web;
	}

	public static Customer createCust(String[] metadata) {
		String first_name = metadata[0];
		String last_name = metadata[1];
		String company_name = metadata[2];
		String address = metadata[3];
		String city = metadata[4];
		String county = metadata[5];
		String state = metadata[6];
		String zip = metadata[7];
		String phone1 = metadata[8];
		String phone2 = metadata[9];
		String email = metadata[10];
		String web = metadata[11];

		// create and return customer of this metadata return
		return new Customer(first_name, last_name, company_name, address, city, county, state, zip, phone1, phone2,
				email, web);
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	// Constructor without arguments
	public Customer() {

	}

	@Override
	public String toString() {
		return "first_name = " + first_name + '\n' + "last_name = " + last_name + '\n' + "company_name = "
				+ company_name + '\n' + "address = " + address + '\n' + "city = " + city + '\n' + "county = " + county
				+ '\n' + "state = " + state + '\n' + "zip = " + zip + '\n' + "phone1 = " + phone1 + '\n' + "phone2 = "
				+ phone2 + '\n' + "email = " + email + '\n' + "web = " + web + '\n';
	}

}
