package application;

public class University {
	int UniID;
	String uniAcronym;
	String uniName;
	String uniCity;
	String uniZipCode;

	public University(String acronym, String name, String city, String zipCode) {
		this.uniAcronym = acronym;
		this.uniName = name;
		this.uniCity = city;
		this.uniZipCode = zipCode;
	}

	/**
	 * @return the uniID
	 */
	/*public int getUniID() {
		return UniID;
	}*/

	/**
	 * @param uniID the uniID to set
	 */
	/*public void setUniID(int uniID) {
		UniID = uniID;
	}*/

	/**
	 * @return the uniAcronym
	 */
	public String getUniAcronym() {
		return uniAcronym;
	}

	/**
	 * @param uniAcronym the uniAcronym to set
	 */
	public void setUniAcronym(String uniAcronym) {
		this.uniAcronym = uniAcronym;
	}

	/**
	 * @return the uniName
	 */
	public String getUniName() {
		return uniName;
	}

	/**
	 * @param uniName the uniName to set
	 */
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	/**
	 * @return the uniCity
	 */
	public String getUniCity() {
		return uniCity;
	}

	/**
	 * @param uniCity the uniCity to set
	 */
	public void setUniCity(String uniCity) {
		this.uniCity = uniCity;
	}

	/**
	 * @return the uniZipCode
	 */
	public String getUniZipCode() {
		return uniZipCode;
	}

	/**
	 * @param uniZipCode the uniZipCode to set
	 */
	public void setUniZipCode(String uniZipCode) {
		this.uniZipCode = uniZipCode;
	}
}
