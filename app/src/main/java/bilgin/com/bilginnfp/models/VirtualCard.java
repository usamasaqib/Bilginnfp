package bilgin.com.bilginnfp.models;
import java.util.*;

/**
 * DAVID DAVENPORT'UN ASKERLERİYİZ
 *
 * @author Mehmet Can Altuntaş
 * github.com/mehmetcc
 */
import java.util.*;
import java.security.MessageDigest;
import java.math.BigInteger;

public class VirtualCard {
    private String cardHolderName;
    private String cardNumber;

    public Card(String name)
    {
        cardHolderName = name;
        cardNumber = md5Has();
    }

    private String md5Hash()
    {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(cardHolderName.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }

        return hashtext;
    }

}
