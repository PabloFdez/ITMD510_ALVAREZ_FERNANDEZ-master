package models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * DataModel class
 * Defines data control and alert model
 */
public class HashingModel {
	public static String hash(String password) {
		MessageDigest md;
		StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
	        byte byteData[] = md.digest();
	        //convert the byte to hex format method 1
	        for (int i = 0; i < byteData.length; i++) {
	        	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return sb.toString();
	}
}
