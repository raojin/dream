package com.qmdj.biz.util.core;

import org.apache.commons.net.util.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xw  @date 2016年10月25日11:03:07
 */
public class RSAUtil {

    private static final String UTF_8 = "UTF-8";

    private static final String RSA = "RSA";

    private static final int MAX_ENCRYPT_BLOCK = 117;//加密最大长度

    private static final int MAX_DECRYPT_BLOCK = 128;//解密最大长度
    
    public static String PUBLICKEY = "publicKey";
    
    public static String PRIVATEKEY = "privateKey";

    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDYzEkQRJEA2RGBVVjdP6PDIA5j0JR9RwHCZo6cLB+gfQyPq+RiWPYUfFdnB/Nkn5VtoLDGnytk7Sw6VtQKrGDQhlbGNcn6C+EOcf2KxOJg/8bD8GiFXtRRZmb9pL7P04gn6vnHkJmgigFzhee0lj9MgzZknUx4xd6OquZ4DxbG2wIDAQAB";

    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANjMSRBEkQDZEYFVWN0/o8MgDmPQlH1HAcJmjpwsH6B9DI+r5GJY9hR8V2cH82SflW2gsMafK2TtLDpW1AqsYNCGVsY1yfoL4Q5x/YrE4mD/xsPwaIVe1FFmZv2kvs/TiCfq+ceQmaCKAXOF57SWP0yDNmSdTHjF3o6q5ngPFsbbAgMBAAECgYAhyp2synMrhaoD1bC3M58r38g+aJlseW/dxCyATSRU2Ijnr+w2JBWfFc5twcB/M5yP7NcA7nhOD+Wv5i7AxyODs3PGd9vLyx7Qt4UxyROn+FDSqtieDp6SjnQMCB7b0snlyz8cSRvfKmk5Jeyu65VpxO8bVWAtOiAJoXZZBihSAQJBAP6DrWGRVrjVvnK/AS8kVsomyQ1iy9EBUkKPbj40vvwM306kK6cBNoefftYPjb+nAnJaydKnrojvlFMAh+dJHdsCQQDaED+OxSPD2rkR95tL4D9KLicNi0c+dveyOXyzYTFBMldK/Pq2pFyE8RDzw648tfpc0kZy13LXlFZ0q0H3s8sBAkEAy6ndJTUjO1c3RiUYMnwWwz8UJZUIWeB/zeluo3Kb3aADVa/DiqlK1G5KFctud42SRKXn2Jz76nIks+K53ddBfwJAF4A+yU03wIjW/ze3NeMyDvWQYeZLxFCf+0Y0yURFQaiCPeOrxXlLO0ybrhm9sm9OTyieTQwpJVCoTKSUVHS9AQJAF0cLY/FX/Aq+AEpZN2FBMdJa5i01phKKMHr2SoqJzyxzc4bxbQB5MPejGqvS68735oWCIXkAtNVcYi93Q7G1IQ==";

    public static final String PUBLIC_KEY_TR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGTvxYdsU2eufB/VohEb9DJKjvjZrWC+x9I9H8\n" +
            "T2SCJC48x2RU1qU/8rNK2MdFqaBGhGBguhAvHY6tSSeuKBY2PhEm89pii8/WAw4rxG7YMgv9VaUG\n" +
            "EEcXoo0qWtImwzxPU0Fq3sVAk8uycAPS8ecTW2mcafUSqIa5HTaR0aZvpwIDAQAB";
    public static final String PRIVATE_KEY_TR = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMZO/Fh2xTZ658H9WiERv0MkqO+N\n" +
            "mtYL7H0j0fxPZIIkLjzHZFTWpT/ys0rYx0WpoEaEYGC6EC8djq1JJ64oFjY+ESbz2mKLz9YDDivE\n" +
            "btgyC/1VpQYQRxeijSpa0ibDPE9TQWrexUCTy7JwA9Lx5xNbaZxp9RKohrkdNpHRpm+nAgMBAAEC\n" +
            "gYBri+6Cs3bkwubpZ9L3WD6X1UvhDrTIHJNWkpSQ9yWVBrYktCYPdJEOCzt8/e+kMgf/9k6mZoHc\n" +
            "a3UzORdR9d+E+qS4BTrnO4p6xqUlM8kF15OoE0fnfu93mvpsUUpqyzdzLRc78fkXWyHObx3lO7pK\n" +
            "W/6oNhLSAdDDl5aKoy6gEQJBAOu3MeVruwKaasYGV0aaZ+fpWM+hnrYfJpynUdsn+95gBV4XpeSi\n" +
            "Z5T3f/IXdAxPQeb6bxU4VlYNK91n7uW0iYMCQQDXX7b0ZRX6zEy73xtYbnqvoCkEuWH5Dlp7gQqH\n" +
            "8U0fw0czy5fhE9eJ8uJRlLJDnwGCbdmsTQGM5d70ZLnBoHwNAkEAwQmTNEZorbYWMTwqJ2j2JSel\n" +
            "kszSNGYIcgxY7fitvSy32JnXQwl5eLbEMlfgsuAJoYaAiElN80TwIm8mZznVzwJBAI8SdmdD/6Xr\n" +
            "sc3cGD5WpgmlS5pnzD2220TQJD7KfYFsKBCwXuSWWci6IL4xGXryVf5fGwrq3OzMh5+yifOmuMEC\n" +
            "QAnbGwBwPswrA86cEtrffwWD6kkwVrsAkeQmX589kUt+iDT1FsXA7xEF5wUqPHIDWE+4MLqMYKIE\n" +
            "xr/AJLYNpVo=";

    public static final String PUBLIC_KEY_QD = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqqJ9moVDt23C0Ef6+lGeNIpEhthyzysyMkL6n\n" +
            "rLYll4eBitqcoORH7a+NOWBJs1f26vxSG++f+W6br6KeYpmjz2OOYceQIUUDxF1p+pc82JMxTT34\n" +
            "bDuqkcGeqrvu3RMnnGQkk7o1jdDa9zEUynivfN/6QvqH5uVjaz0ZBVhMcwIDAQAB";

    public static final String PRIVATE_KEY_QD = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKqon2ahUO3bcLQR/r6UZ40ikSG2\n" +
            "HLPKzIyQvqestiWXh4GK2pyg5Eftr405YEmzV/bq/FIb75/5bpuvop5imaPPY45hx5AhRQPEXWn6\n" +
            "lzzYkzFNPfhsO6qRwZ6qu+7dEyecZCSTujWN0Nr3MRTKeK983/pC+ofm5WNrPRkFWExzAgMBAAEC\n" +
            "gYAE/euzt9JDMuEIE2KtNnAU+8bdApOyWqNDFVTOWMn3LYiELIiafkZPKE+zRNNhNILFMThyOmj2\n" +
            "9/fZS/jowx+VU9X01uEDikGE3u+isNubcTYwFnff6HimxOYWm4isKpoI/XRJ3Dr9jS88ivhBMN41\n" +
            "I6pTzdiNevQ/2/PGovs7CQJBANk8YlJy+7PprTMJA5oBgBoAdouc213WrkpyxNC2dKR6eItG5dp0\n" +
            "bVri1PCibWia0mp2o5TBM0DTP5W0zZjwM20CQQDJHIg50PwnPUY2/Nifk7GvQ+ZWREBmDo07Tuq6\n" +
            "d9RTRyTrSN8J0X7+nBCuclJMtrwaoPaB1yI8V3kj+GQpQLNfAkBA7NYp9CmcDNPx89i6t4YUv1yu\n" +
            "v1OkyRvQLlr6Uf2shtnuLmNWFgP07ORdgv4WDGek4A5l0BREZJ6VXLMx6WBFAkB7BqxDChgmfPJm\n" +
            "EvkFbZlFyTivzyLCC+bTwCwRk9pcc2ofUL24SOLyKFCAFslHyoV5mLwTo6J63Vvq6DmFjuHrAkEA\n" +
            "lYmz6mvCD8vMl/rln6qNhSqT49O8drw3VuFNXX+h0FN+vjWcTwfWzhEM9CO8BaaQ2L2FDZGvzgzn\n" +
            "0SfaPEWh1A==";

    public static void initKey() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA);
            keyPairGen.initialize(1024);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            byte[] publicKey = keyPair.getPublic().getEncoded();
            byte[] privateKey = keyPair.getPrivate().getEncoded();
            System.out.println("publicKey = " + Base64.encodeBase64String(publicKey));
            System.out.println("privateKey = " + Base64.encodeBase64String(privateKey));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("init RSA key error!", e);
        }
    }
    
    /**
     * 生成公钥私钥
     * @author xw
     * @date 2016年10月25日11:02:50
     * @return map
     */
    public static Map<String, String> generateKey() {
    	Map<String, String> key = new HashMap<String, String>();
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA);
			keyPairGen.initialize(1024);
	        KeyPair keyPair = keyPairGen.generateKeyPair();
	        byte[] publicKey = keyPair.getPublic().getEncoded();
	        byte[] privateKey = keyPair.getPrivate().getEncoded();
	        
	        key.put(PUBLICKEY, Base64.encodeBase64String(publicKey));
	        key.put(PRIVATEKEY, Base64.encodeBase64String(privateKey));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("generate RSA key error!", e);
		}
        return key;
    }

    /**
     * 加密
     * @param ming
     * @param publicKey
     * @return
     */
    public static String encryptByPublicKey(String ming, String publicKey) {
        byte[] keys = Base64.decodeBase64(publicKey);//公钥 Base64解码 获取二进制数据
        byte[] mi = encryptByPublicKey(ming.getBytes(), keys);
        //这里密文出去的时候做了Base64转码,防止二进制数组byte[] 数据丢失
        return Base64.encodeBase64String(mi);
    }

    
    /**
     * 解密
     * @param mi
     * @param privateKey
     * @return
     */
    public static String decryptByPrivateKey(String mi, String privateKey) {
        try {
            byte[] keys = Base64.decodeBase64(privateKey);//私钥 Base64解码 获取二进制数据
            //这里密文进来的时候做Base64解码,还原成二进制数组byte[] 数据
            byte[] miBytes = Base64.decodeBase64(mi);
            return new String(decryptByPrivateKey(miBytes, keys), UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decrypt RSA error", e);
        }
    }

    private static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) {
        byte[] result = null;
        try {
            X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey);
            KeyFactory factory = KeyFactory.getInstance(RSA);
            Key publicK = factory.generatePublic(spec);
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicK);
            int len = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] cache;
            int offset = 0;
            int i = 0;
            //加密的时候，明文超过117字节，分组加密拼接
            while (len - offset > 0) {
                if (len - offset > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offset, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offset, len - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_ENCRYPT_BLOCK;
            }
            result = out.toByteArray();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException("encrypt RSA error", e);
        }
        return result;
    }

    private static byte[] decryptByPrivateKey(byte[] data, byte[] privateKey) {
        byte[] result = null;
        try {
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory factory = KeyFactory.getInstance(RSA);
            Key privateK = factory.generatePrivate(spec);
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            //Cipher cipher = Cipher.getInstance(factory.getAlgorithm() + "/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateK);

            int len = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            //解密的时候，密文超过128字节，分组解密拼接
            while (len - offset > 0) {
                if (len - offset > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offset, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offset, len - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_DECRYPT_BLOCK;
            }
            result = out.toByteArray();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException("decrypt RSA error", e);
        }
        return result;
    }

    public static void main(String[] args) {
        //initKey();
        Date now = new Date();
        System.out.println(now.getTime());
        String sql = "{'mobilePhone':'18022222222','password':'123456','userSource':'QD000009','timestamp':'" + now.getTime() + "'}";
        //加密
        String mi = encryptByPublicKey(sql, PUBLIC_KEY_QD);
        System.out.println("---------");
        //密文
        System.out.println(mi);
        System.out.println("----------");


        String ming = decryptByPrivateKey(mi, PRIVATE_KEY_QD);
        System.out.println(ming);
        System.out.println("-----------");
        //是否和明文一致
        System.out.println(ming.equals(sql));
        System.out.println(MD5Util.getMD5Code(ming));
    }
}
