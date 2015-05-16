package tracy.encryption.irreversible;

import java.security.MessageDigest;

/**
 * User: tracy
 * Time: 2015/5/16 19:19
 */
public class SHA1 {
    public static byte[] sha1(byte[] bytes) {
        if (bytes == null)
            throw new IllegalArgumentException();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            return digest.digest(bytes);
        } catch (Exception e) {
            return null;
        }
    }
    public static String md5AsUpperHex(byte[] bytes) {
        return asHex(sha1(bytes), false);
    }
    public static String md5AsLowerHex(byte[] bytes) {
        return asHex(sha1(bytes), true);
    }
    private static final char[] HEX_CHARS_LOWER = "0123456789abcdef".toCharArray();
    private static final char[] HEX_CHARS_UPPER = "0123456789ABCDEF".toCharArray();
    private static String asHex(byte[] bytes, boolean lowerCase) {
        char[] template = lowerCase ? HEX_CHARS_LOWER : HEX_CHARS_UPPER;
        char chars[] = new char[2*bytes.length];
        for (int i = 0; i < chars.length; i = i + 2) {
            byte b = bytes[i / 2];
            chars[i] = template[(b >>> 4) & 0xf];
            chars[i + 1] = template[b & 0xf];
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "SHA-1 test by tracy";
        System.out.println(md5AsUpperHex(str.getBytes()));
    }
}
