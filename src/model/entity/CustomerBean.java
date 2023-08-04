package model.entity;

public class CustomerBean {

	private int customerId;
	private String customerName;
	private String CustomerNameKana;
	private String postalCode;
	private String address;
	private String areaCode;
	private String contactParsonName;
	private String contactPersonNameKana;
	private String userId;
	private String areaName;


	/**
	 * @return customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId セットする customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName セットする customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return customerNameKana
	 */
	public String getCustomerNameKana() {
		return CustomerNameKana;
	}
	/**
	 * @param customerNameKana セットする customerNameKana
	 */
	public void setCustomerNameKana(String customerNameKana) {
		CustomerNameKana = customerNameKana;
	}
	/**
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode セットする postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * @param areaCode セットする areaCode
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * @return contactParsonName
	 */
	public String getContactParsonName() {
		return contactParsonName;
	}
	/**
	 * @param contactParsonName セットする contactParsonName
	 */
	public void setContactParsonName(String contactParsonName) {
		this.contactParsonName = contactParsonName;
	}
	/**
	 * @return contactPersonNameKana
	 */
	public String getContactPersonNameKana() {
		return contactPersonNameKana;
	}
	/**
	 * @param contactPersonNameKana セットする contactPersonNameKana
	 */
	public void setContactPersonNameKana(String contactPersonNameKana) {
		this.contactPersonNameKana = contactPersonNameKana;
	}
	/**
	 * @return contactPersonTel
	 */
	public String getContactPersonTel() {
		return contactPersonTel;
	}


	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return areaName
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * @param areaName セットする areaName
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * @param contactPersonTel セットする contactPersonTel
	 */
	public void setContactPersonTel(String contactPersonTel) {
		this.contactPersonTel = contactPersonTel;
	}
	private String contactPersonTel;


}
