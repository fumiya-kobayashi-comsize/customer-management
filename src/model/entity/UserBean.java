package model.entity;

/**
 * システム利用者を表します。
 * @author 吉田、竹内
 */


public class UserBean{

	private String userId;
	private String password;
	private String userName;
	private String pass;


	/**
	 * userIdの値を返します。
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userIdの値を設定します。
	 * @param userId ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * passwordの値を返します。
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * passwordの値を設定します。
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * userNameの値を返します。
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * フィールドnameの値を設定します。
	 * @param userName 氏名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * passの値を返します。
	 * @return pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * フィールドpassの値を設定します。
	 * @param pass パスワード(ハッシュ化されたもの)
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}


}
