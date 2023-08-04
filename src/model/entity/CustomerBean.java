package model.entity;

import java.sql.Timestamp;

/**
 * DBから取得した値を保持しておく、DBに登録、更新する値を入れておくクラスです。
 * @author 此上
 */

public class CustomerBean {

	private int customerId;
	private String customerName;
	private String customerNameKana;
	private String postalCode;
	private String address;
	private String areaCode;
	private String contactPersonName;
	private String contactPersonNameKana;
	private String contactPersonTel;
	private String userName;
	private String areaName;
	private Timestamp updateDatetime;


	/**
	 * フィールドcustomerIdの値を返します。
	 * @return 顧客ID
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * フィールドcustomerIdの値を設定します。
	 * @param customerId 顧客ID
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * フィールドcustomerNameの値を返します。
	 * @return customerName 顧客名称
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * フィールドcustomerNameの値を設定します。
	 * @param customerName 顧客名称
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * フィールドcustomerNameKanaの値を返します。
	 * @return customerNameKana 顧客名称かな
	 */
	public String getCustomerNameKana() {
		return customerNameKana;
	}
	/**
	 * フィールドcustomerNameKanaの値を設定します。
	 * @param customerNameKana 顧客名称かな
	 */
	public void setCustomerNameKana(String customerNameKana) {
		this.customerNameKana = customerNameKana;
	}

	/**
	 * フィールドpostalCodeの値を返します。
	 * @return postalCode 郵便番号
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * フィールドpostalCodeの値を設定します。
	 * @param postalCode 郵便番号
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * フィールドaddressの値を返します。
	 * @return address 所在地
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * フィールドaddressの値を設定します。
	 * @param address 所在地
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * フィールドareaCodeの値を返します。
	 * @return areaCode 地区コード
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * フィールドareaCodeの値を設定します。
	 * @param areaCode 地区コード
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * フィールドcontactPersonNameの値を返します。
	 * @return contactPersonName 担当者名
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}
	/**
	 * フィールドcontactPersonNameの値を設定します。
	 * @param contactPersonName 担当者名
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	/**
	 * フィールドcontactPersonNameKanaの値を返します。
	 * @return contactPersonNameKana 担当者名かな
	 */
	public String getContactPersonNameKana() {
		return contactPersonNameKana;
	}
	/**
	 * フィールドcontactPersonNameKanaの値を設定します。
	 * @param contactPersonNameKana 担当者名かな
	 */
	public void setContactPersonNameKana(String contactPersonNameKana) {
		this.contactPersonNameKana = contactPersonNameKana;
	}

	/**
	 * フィールドcontactPersonTelの値を返します。
	 * @return contactPersonTel 担当者電話番号
	 */
	public String getContactPersonTel() {
		return contactPersonTel;
	}

	/**
	 * フィールドcontactPersonTelの値を設定します。
	 * @param contactPersonTel 担当者電話番号
	 */
	public void setContactPersonTel(String contactPersonTel) {
		this.contactPersonTel = contactPersonTel;
	}

	/**
	 * フィールドuserNameの値を返します。
	 * @return userName ユーザーName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * フィールドuserNameの値を設定します。
	 * @param userName ユーザーName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * フィールドareaNameの値を返します。
	 * @return areaName 地区名
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * フィールドareaNameの値を設定します。
	 * @param areaName 地区名
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * フィールドupdateDatetimeの値を返します。
	 * @return updateDatetime 更新日時
	 */
	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}
	/**
	 * フィールドupdateDatetimeの値を設定します。
	 * @param updateDatetime 更新日時
	 */
	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
