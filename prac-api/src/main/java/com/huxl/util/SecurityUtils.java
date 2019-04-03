package com.huxl.util;



import javax.crypto.Cipher;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;

/**
 * @author huxl
 * @createDate 2018/1/25 17:17
 */
public class SecurityUtils {

    public static String decrypt(PublicKey publicKey, String cipherText)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        try {
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
        } catch (InvalidKeyException e) {
            // 因为 IBM JDK 不支持私钥加密, 公钥解密, 所以要反转公私钥
            // 也就是说对于解密, 可以通过公钥的参数伪造一个私钥对象欺骗 IBM JDK
            RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
            RSAPrivateKeySpec spec = new RSAPrivateKeySpec(rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());
            Key fakePrivateKey = KeyFactory.getInstance("RSA").generatePrivate(spec);
            cipher = Cipher.getInstance("RSA"); //It is a stateful object. so we need to get new one.
            cipher.init(Cipher.DECRYPT_MODE, fakePrivateKey);
        }

        if (cipherText == null || cipherText.length() == 0) {
            return cipherText;
        }

        byte[] cipherBytes = Base64.base64ToByteArray(cipherText);
        byte[] plainBytes = cipher.doFinal(cipherBytes);

        return new String(plainBytes);
    }
}
