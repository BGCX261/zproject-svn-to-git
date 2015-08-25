package com.zmis.utils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
/** 
 * @author zlj 
 * @since 2010-12-21
 * @version $Revision$ 
 */  
public class Digest 
{  
    /*
     * 不可逆算法  MD5
     */
    public static String Md5(String encode)
    {
    	return DigestUtils.md5Hex(encode);
    }
    /*
     * 不可逆算法  SHA1
     */
    public static String shaHexEncode(String encode)
    {
    	return DigestUtils.shaHex(encode);
    }
    
    
    /**
     * 加密64字符串 (可逆)
     * @param encode
     * @return
     */
    public static String base64Encode(String encode) {
    	byte[] bytes = Base64.encodeBase64(encode.getBytes(), true);
    	return new String(bytes);
    }
    
    /**
     * 解密64字符串 (可逆)
     * @param encode
     * @return
     */
    public static String base64Decode(byte[] decode) {
    	byte[] bytes = Base64.decodeBase64(decode);
    	return new String(bytes);
    }
}