package application;

public class University {
	int UniID;
	String uniAcronym;
	String uniName;
	String uniCity;
	String uniZipCode;

	public University(int ID, String acronym, String name, String city, String zipCode) {
		UniID = ID;
		this.uniAcronym = acronym;
		this.uniName = name;
		this.uniCity = city;
		this.uniZipCode = zipCode;
	}
}
