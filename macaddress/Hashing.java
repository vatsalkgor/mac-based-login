package macaddress;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Hashing {
    protected String hashpass(String password){
        String hashpass = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            BigInteger bigint = new BigInteger(1,digest);
            hashpass = bigint.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return hashpass;
    }
}