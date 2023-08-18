package servlet;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * パスワードをハッシュ化します。
 * @author 竹内
 */
public class HashPass {

	/**
	 * パスワードをハッシュ化する。
	 *
	 * @param password パスワード
	 * @return pass ハッシュ化されたパスワード
	 * @throws NoSuchAlgorithmException
	 */
	public String hash(String password) throws NoSuchAlgorithmException {

		 MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		 //passwordをbyte型で読み込む
		 messageDigest.update(password.getBytes());
		 //byte型の配列を作る
		 byte[] digest = messageDigest.digest();

		 //文字列を操作
		 StringBuffer buffer = new StringBuffer();
		 	for(int i = 0; i < digest.length; i++) {
		 		//16進数に変換
		 		String tmp = Integer.toHexString(digest[i] & 0xff);
		 		//16進数になった配列の要素をつなげる
		 		if(tmp.length() == 1) {
		 			buffer.append('0').append(tmp);
		 		} else {
		 			buffer.append(tmp);
		 		}
		 	}
		 	//String型で受け取る
		 	String pass = buffer.toString();

		 return pass;

	}

}
