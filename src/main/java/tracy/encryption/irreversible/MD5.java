package tracy.encryption.irreversible;

import java.security.MessageDigest;

/**
 * User: tracy
 * Time: 2015/5/16 19:12
 */
public class MD5 {
    /** @return byte[16] */
    public static byte[] md5(byte[] bytes) {
        if (bytes == null)
            throw new IllegalArgumentException();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return digest.digest(bytes);
        } catch (Exception e) {
            return null;
        }
    }

    /** @return String[32] */
    public static String md5AsUpperHex(byte[] bytes) {
        return asHex(md5(bytes), false);
    }
    /** @return String[32] */
    public static String md5AsLowerHex(byte[] bytes) {
        return asHex(md5(bytes), true);
    }
    private static final char[] HEX_CHARS_LOWER = "0123456789abcdef".toCharArray();
    private static final char[] HEX_CHARS_UPPER = "0123456789ABCDEF".toCharArray();
    private static String asHex(byte[] bytes, boolean lowerCase) {
        if (bytes == null || bytes.length != 16)
            throw new IllegalArgumentException();

        char[] template = lowerCase ? HEX_CHARS_LOWER : HEX_CHARS_UPPER;
        char chars[] = new char[32];
        for (int i = 0; i < chars.length; i = i + 2) {
            byte b = bytes[i / 2];
            chars[i] = template[(b >>> 4) & 0xf];
            chars[i + 1] = template[b & 0xf];
        }
        return new String(chars);
    }
}
