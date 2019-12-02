package application;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * University class
 * Defines University Type
 */
public class University {
	String uAcronym;
	String uName;
	String uCity;
	int uZipCode;

	public University(String acronym, String name, String city, int zipCode) {
		this.uAcronym = acronym;
		this.uName = name;
		this.uCity = city;
		this.uZipCode = zipCode;
	}
	
	/**
	 * @return the uniAcronym
	 */
	public String getUniAcronym() {
		return uAcronym;
	}

	/**
	 * @param uniAcronym the uniAcronym to set
	 */
	public void setUniAcronym(String uniAcronym) {
		this.uAcronym = uniAcronym;
	}

	/**
	 * @return the uniName
	 */
	public String getUniName() {
		return uName;
	}

	/**
	 * @param uniName the uniName to set
	 */
	public void setUniName(String uniName) {
		this.uName = uniName;
	}

	/**
	 * @return the uniCity
	 */
	public String getUniCity() {
		return uCity;
	}

	/**
	 * @param uniCity the uniCity to set
	 */
	public void setUniCity(String uniCity) {
		this.uCity = uniCity;
	}

	/**
	 * @return the uniZipCode
	 */
	public int getUniZipCode() {
		return uZipCode;
	}

	/**
	 * @param uniZipCode the uniZipCode to set
	 */
	public void setUniZipCode(int uniZipCode) {
		this.uZipCode = uniZipCode;
	}
}
