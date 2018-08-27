package wusc.edu.pay.facade.user.entity;

import wusc.edu.pay.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/***
 * 在线用户表
 * @author huangbin,WuShuicheng.
 * @desc TableName TBL_USER_INFO
 */
@Table(name = "TBL_USER_INFO")
public class UserInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3419062567494966598L;
	
	/** 账户编号 **/
	@Column(name = "ACCOUNTNO")
	private String accountNo;
	/** 用户编号 **/
	@Column(name = "USERNO")
	private String userNo;
	/** 登录名 **/
	@Column(name = "LOGINNAME")
	private String loginName;
	/** 用户类型 引用UserTypeEnum **/
	@Column(name = "USERTYPE")
	private Integer userType;
	/** 预留信息 **/
	@Column(name = "GREETING")
	private String greeting;
	/** 安全保护问题 **/
	@Column(name = "QUESTION")
	private String question;
	/** 问题答案 **/
	@Column(name = "ANSWER")
	private String answer;
	/** 绑定手机号码 **/
	@Column(name = "BINDMOBILENO")
	private String bindMobileNo;
	/** 绑定邮箱 **/
	@Column(name = "BINDEMAIL")
	private String bindEmail;
	/** 省份 **/
	@Column(name = "PROVINCE")
	private String province;
	/** 所属地区 **/
	@Column(name = "CITY")
	private String city;
	/** 所属区域 **/
	@Column(name = "AREA")
	private String area;
	/** 真实名字  (会员：真实名，商户：FullName)**/

	@Column(name = "REALNAME")
	private String realName;
	
	/** 身份证号码**/
	@Column(name = "CARDNO")
	private String cardNo;
	
	/** 状态**/
	@Column(name = "STATUS")
	private Integer status;
	
	/** 是否邮箱验证(100:是,101:否,默认值为101) **/
	@Column(name = "ISEMAILAUTH")
	private Integer isEmailAuth;
	
	/** 是否手机验证(100:是,101:否,默认值为101) **/
	@Column(name = "ISMOBILEAUTH")
	private Integer isMobileAuth;
	
	/** 是否实名认证(100:是,101:否, 默认值为101) **/
	@Column(name = "ISREALNAMEAUTH")
	private Integer isRealNameAuth;
	
	/**
	 * 账户编号
	 * @return
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * 账户编号
	 * @param accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * 用户编号
	 * @return
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * 用户编号
	 * @param userNo
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * 登录名
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 登录名
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 用户类型
引用UserTypeEnum
	 * @return
	 */
	public Integer getUserType() {
		return userType;
	}
	/**
	 * 用户类型(1:商户,2:会员)
	 * @param userType
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * 预留信息
	 * @return
	 */
	public String getGreeting() {
		return greeting;
	}
	/**
	 * 预留信息
	 * @param greeting
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	/**
	 * 安全保护问题
	 * @return
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 安全保护问题
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 问题答案
	 * @return
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 问题答案
	 * @param answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 绑定手机号码
	 * @return
	 */
	public String getBindMobileNo() {
		return bindMobileNo;
	}
	/**
	 * 绑定手机号码
	 * @param bindMobileNo
	 */
	public void setBindMobileNo(String bindMobileNo) {
		this.bindMobileNo = bindMobileNo;
	}
	/**
	 * 绑定邮箱
	 * @return
	 */
	public String getBindEmail() {
		return bindEmail;
	}
	/**
	 * 绑定邮箱
	 * @param bindEmail
	 */
	public void setBindEmail(String bindEmail) {
		this.bindEmail = bindEmail;
	}
	/**
	 * 省份
	 * @return
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 省份
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 所属地区
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 所属地区
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 所属区域
	 * @return
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 所属区域
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/** 是否邮箱验证 **/
	public Integer getIsEmailAuth() {
		return isEmailAuth;
	}
	
	/** 是否邮箱验证 **/
	public void setIsEmailAuth(Integer isEmailAuth) {
		this.isEmailAuth = isEmailAuth;
	}
	
	/** 是否手机验证 **/
	public Integer getIsMobileAuth() {
		return isMobileAuth;
	}
	
	/** 是否手机验证 **/
	public void setIsMobileAuth(Integer isMobileAuth) {
		this.isMobileAuth = isMobileAuth;
	}
	
	/** 是否实名认证 **/
	public Integer getIsRealNameAuth() {
		return isRealNameAuth;
	}
	
	/** 是否实名认证 **/
	public void setIsRealNameAuth(Integer isRealNameAuth) {
		this.isRealNameAuth = isRealNameAuth;
	}
	
	
	
}
