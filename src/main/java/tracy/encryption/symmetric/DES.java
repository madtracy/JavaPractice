package tracy.encryption.symmetric;

import tracy.encryption.CheckUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * User: tracy
 * Time: 2015/5/16 17:33
 */
public class DES {

    public static byte[] encrypt(byte[] data,byte[] key){
        CheckUtils.notEmpty(data, "data");
        CheckUtils.notEmpty(key, "key");
        try{
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey secKey = skf.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secKey);
            byte[] result = cipher.doFinal(data);
            return result;
        }catch (Exception ex){
            throw new RuntimeException("DES encrypt fail!",ex);
        }
    }

    public static byte[] decrypt(byte[] data,byte[] key){
        CheckUtils.notEmpty(data, "data");
        CheckUtils.notEmpty(key, "key");
        try{
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey secKey = skf.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secKey);
            byte[] result = cipher.doFinal(data);
            return result;
        }catch (Exception ex){
            throw new RuntimeException("DES decrypt fail!",ex);
        }
    }


    public static void main(String[] args) {
        String str = "DES test by tracy!";
        byte[] bytes = str.getBytes();
        for(byte bt : bytes){
            System.out.print(bt);
        }
        System.out.println("");
        //tracy(2015-5-16): String at lest eight
        byte[] key = "madtracy".getBytes();
        byte[] enc = encrypt(bytes,key);
        for(byte bt : enc){
            System.out.print(bt);
        }
        System.out.println("");
        byte[] dec = decrypt(enc,key);
        for(byte bt : dec){
            System.out.print(bt);
        }
    }
}
