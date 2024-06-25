package com.example.demo.common.config.rsa;

import cn.hutool.core.util.ObjectUtil;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: xutu
 * @since: 2024/6/24 10:48
 */
public class RSAUtil {


    public final static String COMPARISON_NAME = "mobilePhone";

    private final static String rsaPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCS5SEvytTesRjhTgChM0XaEU7LGk63whbeHQaTwmptSC68S5+NGLkk/II1Dq10GeNIDxEWhQSDEqPkIXg5e2/vMEWgHMd1jQZyT4FXrn40oMmxZZQfTN3kp2CRgRHNWNuA7UKppQRbJn1V29pRlwTXwtuMo4HbZ3T1siKcRO3sk6nfySR0LWMmCp00Y5doHlJUEzcoxn7dv3UZ2SfpZ2Ll0diCS5f6O2sRnshYZ7dmsMJKO1Q9Djzej1zaLeaJ7wp1tfag82ZCEgPM5Rb37W+Q6w5mdMHxNFdo96v5kXStwVRn8/LkFHGaLZPlEDcNNqxjQzP4r8EnzxZl12wDyQhTAgMBAAECggEBAIrRunEd79mb53VUb8fnWoXggWPzMpz58P5q08JjoowwAOq1VMzUpnNLpglaG5VyuZVpl65+emsb/IIlFybLfla+ea38RIrUgVkZxZQFNQOrR7A73KVP0Qq7Gsmm/hnfdWD711nWtq0lTKENKd6dJ1h3r1/TTW748FEYzRh9E5PT7z9uosU8TSlxdSiT9TNha1U0xRQXUbFylRdEtEQt61R8Ex29JapTxizpLL8Jp7+3vU5XgYmaIXq5TN2qI8fxo3BWsh1jMrj3yMYhXf+pvA8SczyzQduJHisH4Hm5yAKUE6C8XvOaEh09fKPRshiJ5sHKNI8RZx1c/FEzDNkquPECgYEA2nFzvGVKvhvbnB0gjOtrr1gtg1lFQTsWtFOA7DDim4Qxy7dsdRADj0rEvgWhmg30P6bwgSi378zYmL5M/pdnBFqvJIXEve4/G4PD4iyBpTwvpgGVPhG7J4YMkt43uc8dmahnJPs32abQNJjjgk7oaoOvmgDZOtKnU/O6Mn4/Zk8CgYEArCaPqYhBSDhxQrzmgsfulcM+eIZ7Y4LQaC3t6COdeVcpbA+CpBIAK7smBcJXgk3eGCbsFjXHJ+O6+91rEG4MiTW6YifsoS8mYyGyORjuqguovWwYp0S0k9Lr+fV8uYVMmIt8PSPw1P77OGNnM+Uimli7VJ7SD1P0yZIvFtU9gL0CgYB4JjThZ9lfjZUSXhb8S7T0QgzulRh5k5WeY9uijhTmMyTshxwZm1BJ7XcfiZtkT86LgDgC4rGhLUvpX6qb0gzwoSx6azVWvodpi+UfLxm0F9GhfndnJ3uIdrvNwHpoMhp23OC2v5LtnUoh1AI3N02w4HOiwlq5dwpgK8u7YCNhEwKBgHNJS7JcJmPoMKlh+fkhTX0MCN0MKrvEki8Cey2YFFB7d6j/ZhzcVTL0HQ2ETbhcz1xbTIW/NAVZtBISAS46lLiau5waYpS7D7kZitJECSjlr/ZS2tvB3jCU8yUtKn7PbzFFUEldtV3e+HyVzTpqu9ajj6imx8QuFGOdO13OJmb9AoGBAIg1fWMEybVDz0yYkSi/Mxbl2mYxCcp+Fg+KSuAzRmA2KzlBG+8tF8R1VpnD0Pov05hRINIPjf/oJ2jCvmPpZdvIjKNDGEBMWLIHn/JPW0YeJniruTyPfHQ4SZTsmpA8NGtIR6Ihej6W46STaXreHEOLmgN0DqkmJ2CgrZboMrt0";

    public static byte[] decrypt(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    public static String decryptStr(String encryptedString, PrivateKey privateKey) throws Exception {
        byte[] decryptedMessage = decrypt(Base64.getDecoder().decode(encryptedString), privateKey);
        return new String(decryptedMessage);
    }


    public static PrivateKey getPrivateKeyFromBase64(String base64Key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(base64Key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }


    public static void RSAValidated(String mobilePhone, String validatedSeg) {
        Optional<String> result = Stream.of(validatedSeg.split("@"))
                .reduce((first, second) -> second);
        if (ObjectUtil.equals(result.get(), mobilePhone)) {
            System.out.println("tow params are in match.");
            return;
        } else {
            throw new IllegalArgumentException("Request param error.");
        }
    }


    public static void main(String[] args) {
//        RSAValidated("111", "F097C55A-3FFC-4461-9124-BF702996BE43@1719222050.179631@17682449277");


        String encryptedData1 = "E5X5HswJ2ErdTwwKxK5M5cJb7xPT9WMXma4PtQoQC9PbnywO6Px9DZbDRThBoHgRBRqgPxvQcJc7gPjCPZ4IVggtdJNo3yVkzV96E8tMY9jD8H/s/nQD8oCAHpN0XFUPK8zfzK4cqddTosWL9Pw9RQV9zC6U/sdDGTZ2doK8dFU9X43hLflrq/6J+uvDo/+mB6GburGO3M0OOXFR5fXJFBTFlzwNVwCHRPWCf2131+TPBlaOi0d2oLr8kJNTV9Og8kNpasDvXVfIwwpEv3PMelWEbLc+ZlJWMPvHLltX0+o/mVbJgYK9NLOEx6mc1HgXQzgg15IreMvX/O0zarX0qg==";
//        String encryptedData = "c/Pk22HIWQURMRAREFt5Mfrbu/QPXVuyGGuWDVht2E5QwDFa/EDVBHRN3OmHWH+OiM7P3TyDSotLGIXU2ucQ5Ves3zj5p9jWhKhm4hY9jCIWnJebcNVUi/aF8spP5XBAqMfFlL0o8fO8SH0I/LLhCjND7wxCZz9OtFKgPl0lRo1KzA9lXeb7IgtSbDcj5ejoe1RpysuglvBXOCD5AjD93ApWNtnHUlyEb3Mkkbau0SQJw0PyrmOsuPiXIQFOMu7ZCxrU3F6BSeX05PcDxguhw/A/pHirqA6IK8TAzHahvJ5O+Hg2RU4pTsrdMl89PnM+90Ldy0fQ+qZkouEC7poyOw==";
        String encryptedData2 = "Hwox+Z23kdx2iJj4pxmKY3ZTZP2XrfYlmMxdz2KCjqk49B2SXDDJ3Ife4T/fOTreNyHvCmDObf1b2d3DDnC2RJRq7yDEeyQH59cMZDchCqx1si/Dx8y4DSIrquf5+enT/qv6Q+grhQvn6VnwvYhka6jJwaGP4L7g/OBvcL5O+IEUPdt6TiTXd7xOdpnHngsTz3x9rKyxbZ1cIRdNt6BSKGDVTseSwUlCVneURM5qBdLAzD7EcOX0aOEqRjzJxON/l+iITDuvuQxWqSB71aV4ZPtYoIxJAz418SH6tfjLirc8oQVvLtDm1TxemydfXUMD6RLHw9C5X+OEDDpcTSTfpg==";

        String encryptedData = "cgzbk46GJKuW0YyyKUSl2SCXEsevsl3AMneb0kpfo5+L9ad5KeI8IUFzWJrZVytBoEZBIcz/282EI/UApqDHmcY20ARwF1+GCZUNj68EwX9+8nT/ZLyU7qoYN/u/9SDxlml87IqbGu+LJTa+n3+NITElgEpUIuCgd0x85SwxeLleJegCYT0amRErgbRztyKPyh+19iuc/bk/aEJsvcadz/4P+px8+Rqj2H2qawotWGJOkOaNUZcChcfbFgWLbCK5W7ifp5fbkKPxAArIV8Vdq0bEnR2Wdj6wjaz8k9V/t/3oHp8vFkEdfVwvk+plH4YmsziWJ4cnYiNK6fmyDYkbSw==";


//        try {
//            String encode = URLEncoder.encode(encryptedData, StandardCharsets.UTF_8.toString());
//            System.out.println("UrlEncode: " + encode);
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//        String b = "E5X5HswJ2ErdTwwKxK5M5cJb7xPT9WMXma4PtQoQC9PbnywO6Px9DZbDRThBoHgRBRqgPxvQcJc7gPjCPZ4IVggtdJNo3yVkzV96E8tMY9jD8H/s/nQD8oCAHpN0XFUPK8zfzK4cqddTosWL9Pw9RQV9zC6U/sdDGTZ2doK8dFU9X43hLflrq/6J uvDo/ mB6GburGO3M0OOXFR5fXJFBTFlzwNVwCHRPWCf2131 TPBlaOi0d2oLr8kJNTV9Og8kNpasDvXVfIwwpEv3PMelWEbLc ZlJWMPvHLltX0 o/mVbJgYK9NLOEx6mc1HgXQzgg15IreMvX/O0zarX0qg==";
//        if (encryptedData.equals(b)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("not ok");
//        }
//
//        if (encryptedData.equals(bbbbbbbbbbbbb)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("not ok");
//        }

        try {
            String decrypt = decryptStr(encryptedData, getPrivateKeyFromBase64(rsaPrivateKey));
            System.out.println(decrypt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
