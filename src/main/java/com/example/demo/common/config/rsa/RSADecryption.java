package com.example.demo.common.config.rsa;


import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author: xutu
 * @since: 2024/6/21 16:25
 */
public class RSADecryption {

    public final static String constant_base64_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkuUhL8rU3rEY4U4AoTNF2hFOyxpOt8IW3h0Gk8JqbUguvEufjRi5JPyCNQ6tdBnjSA8RFoUEgxKj5CF4OXtv7zBFoBzHdY0Gck+BV65+NKDJsWWUH0zd5KdgkYERzVjbgO1CqaUEWyZ9VdvaUZcE18LbjKOB22d09bIinETt7JOp38kkdC1jJgqdNGOXaB5SVBM3KMZ+3b91Gdkn6Wdi5dHYgkuX+jtrEZ7IWGe3ZrDCSjtUPQ483o9c2i3mie8KdbX2oPNmQhIDzOUW9+1vkOsOZnTB8TRXaPer+ZF0rcFUZ/Py5BRxmi2T5RA3DTasY0Mz+K/BJ88WZddsA8kIUwIDAQAB";

    public final static String constant_base64_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCS5SEvytTesRjhTgChM0XaEU7LGk63whbeHQaTwmptSC68S5+NGLkk/II1Dq10GeNIDxEWhQSDEqPkIXg5e2/vMEWgHMd1jQZyT4FXrn40oMmxZZQfTN3kp2CRgRHNWNuA7UKppQRbJn1V29pRlwTXwtuMo4HbZ3T1siKcRO3sk6nfySR0LWMmCp00Y5doHlJUEzcoxn7dv3UZ2SfpZ2Ll0diCS5f6O2sRnshYZ7dmsMJKO1Q9Djzej1zaLeaJ7wp1tfag82ZCEgPM5Rb37W+Q6w5mdMHxNFdo96v5kXStwVRn8/LkFHGaLZPlEDcNNqxjQzP4r8EnzxZl12wDyQhTAgMBAAECggEBAIrRunEd79mb53VUb8fnWoXggWPzMpz58P5q08JjoowwAOq1VMzUpnNLpglaG5VyuZVpl65+emsb/IIlFybLfla+ea38RIrUgVkZxZQFNQOrR7A73KVP0Qq7Gsmm/hnfdWD711nWtq0lTKENKd6dJ1h3r1/TTW748FEYzRh9E5PT7z9uosU8TSlxdSiT9TNha1U0xRQXUbFylRdEtEQt61R8Ex29JapTxizpLL8Jp7+3vU5XgYmaIXq5TN2qI8fxo3BWsh1jMrj3yMYhXf+pvA8SczyzQduJHisH4Hm5yAKUE6C8XvOaEh09fKPRshiJ5sHKNI8RZx1c/FEzDNkquPECgYEA2nFzvGVKvhvbnB0gjOtrr1gtg1lFQTsWtFOA7DDim4Qxy7dsdRADj0rEvgWhmg30P6bwgSi378zYmL5M/pdnBFqvJIXEve4/G4PD4iyBpTwvpgGVPhG7J4YMkt43uc8dmahnJPs32abQNJjjgk7oaoOvmgDZOtKnU/O6Mn4/Zk8CgYEArCaPqYhBSDhxQrzmgsfulcM+eIZ7Y4LQaC3t6COdeVcpbA+CpBIAK7smBcJXgk3eGCbsFjXHJ+O6+91rEG4MiTW6YifsoS8mYyGyORjuqguovWwYp0S0k9Lr+fV8uYVMmIt8PSPw1P77OGNnM+Uimli7VJ7SD1P0yZIvFtU9gL0CgYB4JjThZ9lfjZUSXhb8S7T0QgzulRh5k5WeY9uijhTmMyTshxwZm1BJ7XcfiZtkT86LgDgC4rGhLUvpX6qb0gzwoSx6azVWvodpi+UfLxm0F9GhfndnJ3uIdrvNwHpoMhp23OC2v5LtnUoh1AI3N02w4HOiwlq5dwpgK8u7YCNhEwKBgHNJS7JcJmPoMKlh+fkhTX0MCN0MKrvEki8Cey2YFFB7d6j/ZhzcVTL0HQ2ETbhcz1xbTIW/NAVZtBISAS46lLiau5waYpS7D7kZitJECSjlr/ZS2tvB3jCU8yUtKn7PbzFFUEldtV3e+HyVzTpqu9ajj6imx8QuFGOdO13OJmb9AoGBAIg1fWMEybVDz0yYkSi/Mxbl2mYxCcp+Fg+KSuAzRmA2KzlBG+8tF8R1VpnD0Pov05hRINIPjf/oJ2jCvmPpZdvIjKNDGEBMWLIHn/JPW0YeJniruTyPfHQ4SZTsmpA8NGtIR6Ihej6W46STaXreHEOLmgN0DqkmJ2CgrZboMrt0";

    public static byte[] decrypt(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    public static String decryptStr(String encryptedString, PrivateKey privateKey) throws Exception {
        byte[] decryptedMessage = decrypt(Base64.getDecoder().decode(encryptedString), privateKey);
        return new String(decryptedMessage);
    }

    public static byte[] encrypt(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    public static PrivateKey getPrivateKeyFromBase64(String base64Key) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] keyBytes = decoder.decode(base64Key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    public static PublicKey getPublicKeyFromBase64(String base64Key) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] keyBytes = decoder.decode(base64Key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    public static void main(String[] args) {
        String message = "Hello, World!";
        PublicKey publicKey = null;
        try {
            publicKey = getPublicKeyFromBase64(constant_base64_public_key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        byte[] encryptedMessage = new byte[0];
        try {
            encryptedMessage = encrypt(message.getBytes(), publicKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String encryptedString = Base64.getEncoder().encodeToString(encryptedMessage);
        System.out.println("Encrypted Message: " + encryptedString);
        try {
            PrivateKey privateKeyFromBase64 = getPrivateKeyFromBase64(constant_base64_private_key);
            String decryptStr = decryptStr(encryptedString, privateKeyFromBase64);
            System.out.println("解密后: " + decryptStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
