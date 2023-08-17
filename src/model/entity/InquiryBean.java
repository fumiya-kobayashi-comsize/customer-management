package model.entity;

import java.sql.Timestamp;

/**
 * t_inquiryから取得した値を保持しておく、t_inquiryに登録、更新する値を入れておくクラスです。
 * @author 此上
 */

public class InquiryBean {
	private int inquiryId;
	private int customerId;
	private String customerName;
	private Timestamp inquiryDatetime;
	private String inquiryContents;
	private String replyContents;
	private String statusCode;
	private String statusName;
	private Timestamp updateDatetime;

	/**
	 * フィールドinquiryIdの値を返します。
	 * @return 問合せ履歴ID
	 */
	public int getInquiryId() {
		return inquiryId;
	}
	/**
	 * フィールドinquiryIdの値を設定します。
	 * @param inquiryId 問合せ履歴ID
	 */
	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

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
	 * @return 顧客名
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * フィールドcustomerNameの値を設定します。
	 * @param customerName 顧客名
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * フィールドinquiryDatetimeの値を返します。
	 * @return 問合せ日時
	 */
	public Timestamp getInquiryDatetime() {
		return inquiryDatetime;
	}
	/**
	 * フィールドinquiryDatetimeの値を設定します。
	 * @param inquiryDatetime 問合せ日時
	 */
	public void setInquiryDatetime(Timestamp inquiryDatetime) {
		this.inquiryDatetime = inquiryDatetime;
	}

	/**
	 * フィールドinquiryContentsの値を返します。
	 * @return 問合せ内容
	 */
	public String getInquiryContents() {
		return inquiryContents;
	}
	/**
	 * フィールドinquiryContentsの値を設定します。
	 * @param inquiryContents 問合せ内容
	 */
	public void setInquiryContents(String inquiryContents) {
		this.inquiryContents = inquiryContents;
	}

	/**
	 * フィールドreplyContentsの値を返します。
	 * @return 回答内容
	 */
	public String getReplyContents() {
		return replyContents;
	}
	/**
	 * フィールドreplyContentsの値を設定します。
	 * @param replyContents 回答内容
	 */
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	/**
	 * フィールドstatusCodeの値を返します。
	 * @return ステータスコード
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * フィールドstatusCodeの値を設定します。
	 * @param statusCode ステータスコード
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * フィールドstatusNameの値を返します。
	 * @return ステータス名
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * フィールドstatusNameの値を設定します。
	 * @param statusName ステータ名
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * フィールドupdateDatetimeの値を返します。
	 * @return 更新日時
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
