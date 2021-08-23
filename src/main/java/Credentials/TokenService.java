package Credentials;

import net.thucydides.core.annotations.Step;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TokenService {

    @Step
    public String generateAuthTokenV1(String msg, String secret, String algo) {
        String digest;
        SecretKeySpec key;
        key = new SecretKeySpec((secret).getBytes(StandardCharsets.UTF_8), algo);
        Mac mac = null;
        try {
            mac = Mac.getInstance(algo);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            assert mac != null;
            mac.init(key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        byte[] bytes;
        bytes = mac.doFinal(msg.getBytes(StandardCharsets.US_ASCII));

        StringBuilder hash = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xFF & aByte);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }
        digest = hash.toString();

        return digest;
    }
}
